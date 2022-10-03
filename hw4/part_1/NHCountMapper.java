import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NHCountMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyText = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] lineArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (lineArray[0].equals("id")) {
            // do nothing
        } else {
            try {
                if (lineArray[4] != null && lineArray[5] != null) {
                    if (lineArray[5].matches(".*\\d.*")) {
                        // do nothing (comma indexing wrong)
                    } else {
                        String newKey = String.format("%1$s %2$s", lineArray[4], lineArray[5]);
                        keyText.set(newKey);
                        context.write(keyText, new IntWritable(1));
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                // do nothing
            }
        }
    }
}
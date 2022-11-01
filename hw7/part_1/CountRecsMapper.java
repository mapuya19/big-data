import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountRecsMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyText = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] lineArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (lineArray[0].equals("Project ID")) {
            // do not count header row
        } else {
            context.write(new Text("Record"), new IntWritable(1)); 
            // try {
            //     if (lineArray[4] != null && lineArray[5] != null) {
                       
            //     }
            // } catch (IndexOutOfBoundsException e) {
            //     // do nothing
            // }
        }
    }
}
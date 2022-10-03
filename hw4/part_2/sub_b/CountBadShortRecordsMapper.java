import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountBadShortRecordsMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyText = new Text("Total number of short lines in AirBNB file: ");

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] lineArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (lineArray.length < 16) {
            context.write(keyText, new IntWritable(1));
        } else {
            // do nothing
        }
    }
}
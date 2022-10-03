import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountLinesMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyText = new Text("Total number of lines in AirBNB file: ");

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        context.write(keyText, new IntWritable(1));
    }
}

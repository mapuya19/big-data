import java.util.HashMap;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class CleanReducer extends Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Text value, Context context)
            throws IOException, InterruptedException {
        // int sum = 0;

        // for (IntWritable val : values) {
        //     sum += val.get();
        // }

        // String keyToString = "Total Amount of Records: ";

        context.write(new Text(key), new Text(""));
    }
}

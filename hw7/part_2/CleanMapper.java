import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text keyText = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] lineArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        if (lineArray[0].equals("Project ID")) {
            // do not count header row
        } else {
            String projectId = lineArray[0];
            String borough = lineArray[7];
            String postCode = lineArray[8];
            String countedUnits = lineArray[39];
            String totalUnits = lineArray[40];

            if (postCode.isEmpty()) {
                // remove row
            } else {
                context.write(
                        new Text(projectId + "," + borough + "," + postCode + "," + countedUnits + "," + totalUnits),
                        new Text(""));
            }
        }
    }
}

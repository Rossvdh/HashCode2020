package hashcode.the.reckoning.io;

import com.google.common.io.Files;
import hashcode.the.reckoning.domain.output.Solution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

public class SolutionWriter {

    public void writeToFile(String filename, Solution result) {

        File file = new File("./" + filename);

        try {
            Files.asCharSink(file, UTF_8).write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //public List<String> parse(final Solution result) {
    //    List<String> parsedList = new ArrayList<>();
    //    /*for(Vechile vechile : result.getVechileList()) {
    //        if(vechile.getRides().size() > 0){
    //            parsedList.add(vechile.print());
    //        }
    //    }*/
    //    return parsedList;
    //}
}

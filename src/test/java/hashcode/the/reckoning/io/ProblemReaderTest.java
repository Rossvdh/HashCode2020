package hashcode.the.reckoning.io;

import hashcode.the.reckoning.domain.input.ProblemSet;
import org.junit.Test;

/**
 *
 */
public class ProblemReaderTest {

    ProblemReader problemReader;


    @Test
    public void readFile() {

        problemReader = new ProblemReader("a_example.in");

        final ProblemSet problemSet = problemReader.readFile();

        System.out.println(problemSet);

    }
}

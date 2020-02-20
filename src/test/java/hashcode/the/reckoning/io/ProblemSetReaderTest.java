package hashcode.the.reckoning.io;

import hashcode.the.reckoning.domain.input.ProblemSet;
import org.junit.Test;

/**
 *
 */
public class ProblemSetReaderTest {

    ProblemSetReader problemSetReader;

    @Test
    public void readFile() {

        problemSetReader = new ProblemSetReader("a_example.in");

        final ProblemSet problemSet = problemSetReader.readFile();

        System.out.println(problemSet);
    }
}

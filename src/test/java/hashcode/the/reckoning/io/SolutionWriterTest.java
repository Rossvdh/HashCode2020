package hashcode.the.reckoning.io;

import hashcode.the.reckoning.domain.output.Solution;
import hashcode.the.reckoning.domain.output.Vechile;
import org.junit.Test;

import java.util.ArrayList;

/**
 *
 */
public class SolutionWriterTest {


    @Test
    public void writeOut() {

        SolutionWriter solutionWriter = new SolutionWriter();

        Solution solution = new Solution();
        solution.setVechileList(new ArrayList<>());

        Vechile vechile = new Vechile();
        vechile.getRides().add(1);
        vechile.getRides().add(2);

        vechile.getRides().add(4);
        vechile.getRides().add(5);

        solution.getVechileList().add(vechile);

        vechile = new Vechile();
        vechile.getRides().add(5);
        vechile.getRides().add(6);

        solution.getVechileList().add(vechile);

        vechile = new Vechile();

        solution.getVechileList().add(vechile);

        solutionWriter.writeToFile("test.out", solution);

    }
}

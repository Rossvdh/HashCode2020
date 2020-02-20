package hashcode.the.reckoning;

import hashcode.the.reckoning.domain.input.ProblemSet;
import hashcode.the.reckoning.domain.output.Solution;
import hashcode.the.reckoning.io.ProblemSetReader;
import hashcode.the.reckoning.io.SolutionWriter;
import hashcode.the.reckoning.solve.Solver;
import hashcode.the.reckoning.solve.TickingSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> fileList = new ArrayList<>();
        fileList.add("a_example");
        fileList.add("b_should_be_easy");
        fileList.add("c_no_hurry");
        fileList.add("d_metropolis");
        fileList.add("e_high_bonus");

        fileList.forEach( filename -> {
            System.out.println(filename + ".in");

            System.out.println("Input");
            ProblemSetReader reader = new ProblemSetReader(filename + ".in");
            ProblemSet input = reader.readFile();

            System.out.println("Solving");
            Solution result = solveProblem(input);

            System.out.println("Output");
            generateOutput(filename + ".out", result);
            System.out.println("Done " + filename);
        });

    }

    private static Solution solveProblem(ProblemSet input) {

        Solver solution = new TickingSolver();
        return solution.solve(input);
    }

    private static void generateOutput(String inputPathStr, Solution result) {
        SolutionWriter fileWriter = new SolutionWriter();

        fileWriter.writeToFile(inputPathStr, result);

    }
}

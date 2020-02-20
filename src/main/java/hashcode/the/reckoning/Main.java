package hashcode.the.reckoning;

import hashcode.the.reckoning.domain.input.ProblemSet;
import hashcode.the.reckoning.domain.output.Solution;
import hashcode.the.reckoning.io.ProblemReader;
import hashcode.the.reckoning.io.SolutionWriter;
import hashcode.the.reckoning.solve.SimpleSolver;
import hashcode.the.reckoning.solve.Solver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> fileList = new ArrayList<>();
        fileList.add("a_example");

        fileList.forEach(filename -> {
            System.out.println(filename + ".txt");

            System.out.println("Input");
            ProblemReader reader = new ProblemReader(filename + ".txt");
            ProblemSet input = reader.readFile();

            System.out.println("Solving");
            Solution result = solveProblem(input);

            System.out.println("Output");
            generateOutput(filename + ".out", result);
            System.out.println("Done " + filename);
        });
    }

    private static Solution solveProblem(ProblemSet input) {
        Solver solution = new SimpleSolver();
        return solution.solve(input);
    }

    private static void generateOutput(String inputPathStr, Solution result) {
        SolutionWriter fileWriter = new SolutionWriter();

        fileWriter.writeToFile(inputPathStr, result);
    }
}

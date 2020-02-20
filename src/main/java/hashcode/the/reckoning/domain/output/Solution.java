package hashcode.the.reckoning.domain.output;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Solution {
    // Store the actual solution and prep for printing
    List<SolutionLibrary> libraries = new ArrayList<>();
    long scoreForSolution = 0;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(libraries.size()));
        for (SolutionLibrary library : libraries) {
            stringBuilder.append(library);
        }

        return stringBuilder.toString();
    }

    public void addLibrarySolution(SolutionLibrary solutionLibrary) {
        libraries.add(solutionLibrary);
        scoreForSolution += solutionLibrary.getTotalSolutionLibraryPoints();
    }
}

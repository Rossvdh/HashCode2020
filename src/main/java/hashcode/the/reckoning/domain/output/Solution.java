package hashcode.the.reckoning.domain.output;

import lombok.Data;

import java.util.List;

@Data
public class Solution {
    // Store the actual solution and prep for printing
    List<SolutionLibrary> libraries;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(libraries.size());
        for (SolutionLibrary library : libraries) {
            stringBuilder.append(library);
        }

        return stringBuilder.toString();
    }
}

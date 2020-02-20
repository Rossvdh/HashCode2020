package hashcode.the.reckoning.solve;

import hashcode.the.reckoning.domain.input.ProblemSet;
import hashcode.the.reckoning.domain.output.Solution;

public interface Solver {

    Solution solve(ProblemSet input);
}

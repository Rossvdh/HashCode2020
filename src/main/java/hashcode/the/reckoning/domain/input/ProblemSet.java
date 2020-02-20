package hashcode.the.reckoning.domain.input;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
@Data
@ToString()
public class ProblemSet {
    // Class for storing anything useful for solving the problem
    // Data fields of interest
    // The actual lines of input data
    long totalDaysToScan;
    long nrLibs;
    long nrBooks;
    HashMap<Long, Long> booksAndRatingsMap = new HashMap<>();
    List<Library> libraries;
}

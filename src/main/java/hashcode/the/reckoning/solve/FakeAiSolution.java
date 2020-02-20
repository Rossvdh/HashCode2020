package hashcode.the.reckoning.solve;

import hashcode.the.reckoning.domain.input.Book;
import hashcode.the.reckoning.domain.input.Library;
import hashcode.the.reckoning.domain.input.ProblemSet;
import hashcode.the.reckoning.domain.output.Solution;
import hashcode.the.reckoning.domain.output.SolutionLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class FakeAiSolution implements Solver {

    @Override
    public Solution solve(final ProblemSet problemSet) {
        long daysRemaining = problemSet.getTotalDaysToScan();
        Solution currentSolution = new Solution();
        HashMap<Long, Boolean> hasBookBeenAdded = new HashMap<>();

        List<Library> libariesToBeUsed = new ArrayList<>();
        libariesToBeUsed.addAll(problemSet.getLibraries());

        while (daysRemaining > 0 && libariesToBeUsed.size() > 0) {

            // Get and remove to mark library as used.
            Library library = libariesToBeUsed.get(0);
            libariesToBeUsed.remove(0);

            if (daysRemaining - library.getDaysToSignup() < 0) {
                continue;
            }

            SolutionLibrary solutionLibrary = new SolutionLibrary();
            solutionLibrary.setLibraryId(library.getId());

            long intBooksThatCanBeProcessed = daysRemaining * library.getBooksPerDay();
            List<Book> listOfBooks = library.getListOfBooks();
            if (intBooksThatCanBeProcessed > 0) {
                for (int bookIndex = 0; bookIndex < listOfBooks.size(); bookIndex++) {
                    Book book = listOfBooks.get(bookIndex);
                    if (bookIndex < intBooksThatCanBeProcessed) {
                        solutionLibrary.addLibrarySolution(book);
                        hasBookBeenAdded.put(book.getId(), true);
                    } else {
                        break;
                    }
                }
            }
            if (solutionLibrary.getTotalSolutionLibraryPoints() > 0 && solutionLibrary.getBooksIds().size() > 0) {
                daysRemaining -= library.getDaysToSignup();
                currentSolution.addLibrarySolution(solutionLibrary);
            }
            List<Library> libraries = problemSet.getLibraries();
            for (Library libraryForFitness : libraries) {
                libraryForFitness.calculateFitness(daysRemaining, hasBookBeenAdded);
            }

            libraries.sort(new Comparator<Library>() {
                @Override
                public int compare(Library o1, Library o2) {
                    if (o2.getFitness() > o1.getFitness()) {
                        return 1;
                    } else if (o2.getFitness() < o1.getFitness()) {
                        return -1;
                    } else return 0;
                }
            });
        }
        return currentSolution;
    }
}

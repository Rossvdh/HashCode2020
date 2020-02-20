package hashcode.the.reckoning.solve;

import hashcode.the.reckoning.domain.input.Book;
import hashcode.the.reckoning.domain.input.Library;
import hashcode.the.reckoning.domain.input.ProblemSet;
import hashcode.the.reckoning.domain.output.Solution;
import hashcode.the.reckoning.domain.output.SolutionLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SimpleSolver implements Solver {
    @Override
    public Solution solve(final ProblemSet problemSet) {

        Solution bestSolution = new Solution();

        for (int startLibraryIndex = 0; startLibraryIndex < problemSet.getLibraries().size(); startLibraryIndex++) {
            int index = startLibraryIndex;
            long daysRemaining = problemSet.getTotalDaysToScan();
            Solution currentSolution = new Solution();
            List<Library> libariesToBeUsed = new ArrayList<>();
            libariesToBeUsed.addAll(problemSet.getLibraries());

            while (daysRemaining > 0 && libariesToBeUsed.size() > 0) {
                if (libariesToBeUsed.size() <= index) {
                    index = 0;
                }


                // Get and remove to mark library as used.
                Library library = libariesToBeUsed.get(index);
                libariesToBeUsed.remove(index);
                index++;

                daysRemaining -= library.getDaysToSignup();

                SolutionLibrary solutionLibrary = new SolutionLibrary();
                solutionLibrary.setLibraryId(library.getId());

                long intBooksThatCanBeProcessed = daysRemaining * library.getBooksPerDay();
                List<Book> listOfBooks = library.getListOfBooks();
                if (intBooksThatCanBeProcessed > 0) {
                    for (int bookIndex = 0; bookIndex < listOfBooks.size(); bookIndex++) {
                        Book book = listOfBooks.get(bookIndex);
                        if (bookIndex < intBooksThatCanBeProcessed) {
                            solutionLibrary.addLibrarySolution(book);
                        } else {
                            break;
                        }
                    }
                }
                if (solutionLibrary.getBooksIds().size() >0){
                currentSolution.addLibrarySolution(solutionLibrary);
                }
                if (bestSolution.getScoreForSolution() < currentSolution.getScoreForSolution()) {
                    bestSolution = currentSolution;
                }
            }
            return currentSolution;
        }

        return bestSolution;
    }
}

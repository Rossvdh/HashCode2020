package hashcode.the.reckoning.domain.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Library {
    long id;
    long nrBooks;
    List<Book> listOfBooks;
    long daysToSignup;
    long booksPerDay;
    long fitness;

    public Library(long id, long nrBooks, List<Book> listOfBooks, long daysToSignup) {
        this.id = id;
        this.nrBooks = nrBooks;
        this.listOfBooks = listOfBooks;
        this.daysToSignup = daysToSignup;
    }

    public List<Book> getDistinctBooks(HashMap<Long, Boolean> hasBookBeenAdded) {
        return this.listOfBooks.stream().filter(new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                return !hasBookBeenAdded.containsKey(book.getId());
            }
        }).collect(Collectors.toList());
    }

    public void calculateFitness(long nrDaysForProblem) {
        long daysRemaining = nrDaysForProblem - daysToSignup;
        long totalBooksThatCanBeProcesed = ((daysRemaining) * booksPerDay);

        double totalScoreForBooksToBeProcessed = 0;
        long valueToUse =
                totalBooksThatCanBeProcesed > listOfBooks.size() ? listOfBooks.size() : totalBooksThatCanBeProcesed;

        for (int bookIndex = 0; bookIndex < listOfBooks.size(); bookIndex++) {
            Book book = listOfBooks.get(bookIndex);
            if (bookIndex < totalBooksThatCanBeProcesed) {
                totalScoreForBooksToBeProcessed += book.score;
            } else {
                break;
            }
        }

        double avgScorePerBook = valueToUse > 0 ? totalScoreForBooksToBeProcessed / valueToUse : 0;

        fitness = (long) ((1 - (daysToSignup * 1.00 / nrDaysForProblem)) * 1.00 * totalBooksThatCanBeProcesed *
                avgScorePerBook * 1.00);
    }
}

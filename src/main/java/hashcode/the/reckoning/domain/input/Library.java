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
                return hasBookBeenAdded.get(book.getId());
            }
        }).collect(Collectors.toList());
    }
}

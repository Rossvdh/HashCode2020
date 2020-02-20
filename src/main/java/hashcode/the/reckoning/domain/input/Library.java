package hashcode.the.reckoning.domain.input;

import lombok.Data;

import java.util.List;

@Data
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
}

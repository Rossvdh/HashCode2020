package hashcode.the.reckoning.domain.output;

import hashcode.the.reckoning.domain.input.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SolutionLibrary {

    long libraryId;
    long totalSolutionLibraryPoints = 0;
    List<Long> booksIds = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n" + libraryId + " " + booksIds.size() + "\n");
        stringBuilder.append(booksIds.stream().map(value -> Long.toString(value)).collect(Collectors.joining(" ")));
        return stringBuilder.toString();
    }

    public void addLibrarySolution(Book book) {
        booksIds.add(book.getId());
        totalSolutionLibraryPoints += book.getScore();
    }
}

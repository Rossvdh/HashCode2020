package hashcode.the.reckoning.domain.output;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SolutionLibrary {

    long libraryId;
    List<Long> booksIds;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n" + libraryId + " " + booksIds.size() + "\n");
        stringBuilder.append(booksIds.stream().map(value -> Long.toString(value)).collect(Collectors.joining(" ")));
        return stringBuilder.toString();
    }
}

package hashcode.the.reckoning.io;

import com.google.common.base.Splitter;
import hashcode.the.reckoning.Main;
import hashcode.the.reckoning.domain.input.Book;
import hashcode.the.reckoning.domain.input.Library;
import hashcode.the.reckoning.domain.input.ProblemSet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Charsets.UTF_8;

public class ProblemReader {
    private String fileName;

    public ProblemReader(String fileName) {
        this.fileName = fileName;
    }

    public ProblemSet readFile() {
        ProblemSet problemSet = new ProblemSet();

        final List<String> inputLines = readFromFile(fileName);

        // Read first line
        final String firstLine = inputLines.get(0);
        inputLines.remove(0);
        final List<Long> firstSplit = splitLineBySpace(firstLine);
        problemSet.setNrBooks(firstSplit.get(0));
        problemSet.setNrLibs(firstSplit.get(1));
        problemSet.setTotalDaysToScan(firstSplit.get(2));

        // Book ratings
        final String booksLine = inputLines.get(0);
        List<Long> bookRatings = splitLineBySpace(booksLine);
        HashMap<Long, Long> booksAndRatingsMap = problemSet.getBooksAndRatingsMap();
        for (long i = 0; i < bookRatings.size(); i++) {
            booksAndRatingsMap.put(i, bookRatings.get((int) i));
        }
        inputLines.remove(0);

        List<Library> libraries = new ArrayList<>();
        Iterator<String> iterator = inputLines.iterator();
        int libraryId = 0;
        while (iterator.hasNext()) {
            String libraryDefiningLine = iterator.next();
            String booksDefiningLine = iterator.next();

            List<Long> libraryData = splitLineBySpace(libraryDefiningLine);
            List<Long> libraryBooks = splitLineBySpace(booksDefiningLine);

            Library library = new Library();
            library.setId(libraryId++);
            library.setNrBooks(libraryData.get(0));
            library.setDaysToSignup(libraryData.get(1));
            library.setBooksPerDay(libraryData.get(2));

            List<Book> books = new ArrayList<>();
            for (Long libraryBookId : libraryBooks) {
                Book book = new Book();
                book.setId(libraryBookId);
                book.setScore(booksAndRatingsMap.get(libraryBookId));
                books.add(book);
            }

            library.setListOfBooks(books);
            libraries.add(library);
        }

        return problemSet;
    }

    private List<Long> splitLineBySpace(String line) {
        List<String> strings = Splitter.on(' ').omitEmptyStrings().trimResults().splitToList(line);
        return strings.parallelStream().map(s -> Long.parseLong(s)).collect(Collectors.toList());
    }

    public List<String> readFromFile(final String fileName) {
        URL resource = Main.class.getResource(fileName);
        File file = new File(resource.getFile());

        try {
            final List<String> lines = com.google.common.io.Files.readLines(file, UTF_8);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

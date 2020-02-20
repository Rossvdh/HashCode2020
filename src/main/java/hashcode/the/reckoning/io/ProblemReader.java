package hashcode.the.reckoning.io;

import com.google.common.base.Splitter;
import hashcode.the.reckoning.Main;
import hashcode.the.reckoning.domain.input.ProblemSet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.base.Charsets.UTF_8;

public class ProblemReader {
    private String fileName;

    public ProblemReader(String fileName) {
        this.fileName = fileName;
    }

    public ProblemSet readFile() {
        ProblemSet problemSet = new ProblemSet();

        final List<String> strings = readFromFile(fileName);

        final String firstLine = strings.get(0);
        strings.remove(0);

        final List<String> firstSplit = Splitter.on(' ').omitEmptyStrings().trimResults().splitToList(firstLine);

       /* problemSet.setRows(Integer.parseInt(firstSplit.get(0)));
        problemSet.setColumns(Integer.parseInt(firstSplit.get(1)));
        problemSet.setVechiles(Integer.parseInt(firstSplit.get(2)));
        problemSet.setRides(Integer.parseInt(firstSplit.get(3)));
        problemSet.setBonus(Integer.parseInt(firstSplit.get(4)));
        problemSet.setSteps(Integer.parseInt(firstSplit.get(5)));
        problemSet.setRideList(new ArrayList<>());

        int rideIndex = 0;
        for(String line : strings) {
            final List<String> rideSplit = Splitter.on(' ').omitEmptyStrings().trimResults().splitToList(line);
            Ride ride = new Ride();
            ride.setId(rideIndex);
            ride.setA(Integer.parseInt(rideSplit.get(0)));
            ride.setB(Integer.parseInt(rideSplit.get(1)));
            ride.setX(Integer.parseInt(rideSplit.get(2)));
            ride.setY(Integer.parseInt(rideSplit.get(3)));
            ride.setEarStart(Integer.parseInt(rideSplit.get(4)));
            ride.setLatestFin(Integer.parseInt(rideSplit.get(5)));
            ride.calcDistance();
            problemSet.getRideList().add(ride);
            rideIndex++;
        }*/

        return problemSet;
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

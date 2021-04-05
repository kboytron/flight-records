import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Query4 {

    public static Iterable<String> Query4(Iterable<FlightRecord> input) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query4(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Query9 {
    public static Iterable<String> Query9(Iterable<FlightRecord> input) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> rs = Query9(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}

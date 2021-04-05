import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Query6 {
    public static String Query6(Iterable<FlightRecord> input) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query6(input);
        System.out.println(r);
    }
}

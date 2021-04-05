import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Query1 {

    public static int Query1(Iterable<FlightRecord> input) {
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        int total = Query1(input);
        System.out.println(total);
    }
}

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Query8 {
    public static Iterable<String> Query8(Iterable<FlightRecord> input) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        Iterable<String> rs = Query8(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}

import java.io.IOException;
import java.util.*;

public class Query3 {

    public static int Query3(Iterable<FlightRecord> input) {
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2019.csv");
        int results = Query3(input);
        System.out.println(results);
    }
}

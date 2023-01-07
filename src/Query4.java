import java.io.IOException;
import java.util.*;

public class Query4 {

    public static Iterable<String> Query4(Iterable<FlightRecord> input) {

        Map<String, Integer> destination = new HashMap<>();
        Set<String> result = new HashSet<>();

        //this is going to find all the flights from cid and count the quantity of flights to the same destination
        for (FlightRecord cid : input) {
            if (cid.ORIGIN.equals("CID")) {
                destination.merge(cid.DEST, 1, Integer::sum);
            }
        }

        //this is to convert the map from above into a set with strings only
        for(Map.Entry<String, Integer> fin : destination.entrySet()){
            result.add(fin.getKey() + "=" + fin.getValue());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query4(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}

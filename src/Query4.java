import java.io.IOException;
import java.util.*;

public class Query4 {

    public static Iterable<String> Query4(Iterable<FlightRecord> input) {

        Map<String, Integer> dest = new HashMap<>();

        for (FlightRecord cid : input) {
            if (cid.ORIGIN.equals("CID")) {
                dest.merge(cid.DEST, 1, Integer::sum);
            }
        }
        Set<String> result = new HashSet<>();

        for(Map.Entry<String, Integer> fin : dest.entrySet()){
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

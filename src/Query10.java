import java.io.IOException;
import java.util.*;

public class Query10 {

    public static Iterable<String> Query10(Iterable<FlightRecord> input) {
        Map<String, String> departures = new HashMap<>(); //departures
        Map<String, String> arrivals = new HashMap<>(); //arrivals
        Set<String> result = new HashSet<>();

        //this query is to show how many different ways you can get to lax from cid in two flights

        for(FlightRecord cid: input ) {
            if (cid.ORIGIN.equals("CID")) { departures.put(cid.DEST, cid.ORIGIN); } // store flights from cid
            if (cid.DEST.equals("LAX")) { arrivals.put(cid.ORIGIN, cid.DEST); } //lax arrivals
        }
        for(String i: departures.keySet()){
            if(arrivals.containsKey(i)){ result.add("CID->" + i + "->LAX"); } //if a departure and arrival can be chained we add it
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        Timer t = new Timer();
        t.start();
        Iterable<String> results = Query10(input);
        t.end();
        for (String s : results) {
            System.out.println(s);
        }
        System.out.println(t.elapsedSeconds());
    }
}
import java.io.IOException;
import java.util.*;

public class Query9 {
    public static Iterable<String> Query9(Iterable<FlightRecord> input) {
        Map<String, Map<String, Integer>> flights = new HashMap<>();
        //nested map that holds state, airline and count of flights

        //in this query we want to find which airline flies to each state the most

        for(FlightRecord cid: input){
            String airline = cid.UNIQUE_CARRIER_NAME;
            String dest = cid.DEST_STATE_ABR;

            if(flights.containsKey(dest)){
                if(flights.get(dest).containsKey(airline)){
                    flights.get(dest).put(airline, flights.get(dest).get(airline)+1);
                } // if the airline exists one is added with number of flights into the state
                else{ flights.get(dest).put(airline, 1); }
                 // key is created if airline hasn't been put in yet
            }
            else{
                Map<String, Integer> setter = new HashMap<>();
                setter.put(airline, 1);
                flights.put(dest, setter); // if state does not exist
            }
        }

        int max;
        String strMax;
        Set<String> result = new HashSet<>();
        for(String i: flights.keySet()){
            max = 0;
            strMax = ""; // here the variables created are reset
            for(String j: flights.get(i).keySet()){
                if( max < flights.get(i).get(j)){
                    strMax = j;
                    max = flights.get(i).get(j); // comparison
                }
            }

            result.add(i + "," + strMax); // final addition
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> rs = Query9(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
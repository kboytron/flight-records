import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Query8 {
    public static Iterable<String> Query8(Iterable<FlightRecord> input) {
        Map<String, Integer[]> total = new TreeMap<>();
        Set<String> result = new HashSet<>();

        //this query asks what percentage of flights stay in the same state
        for(FlightRecord cid: input){
            int count;
            String state = cid.ORIGIN_STATE_ABR;

            if(state.equals(cid.DEST_STATE_ABR)) { count = 1; }
            else{ count = 0; }

            Integer[] flight; // to store both total and in state flights

            if(total.containsKey(state)){
                flight = total.get(state);

                flight[0] += count; // within state flights
                flight[1] += 1; // total flights
            }

            else{ flight = new Integer[]{count, 1}; } // creates new entry

            total.put(state, flight); // adds the flight to the treemap
        }

        for(String state: total.keySet()){
            Integer[] calc = total.get(state);
            int interstateFlights = calc[0];
            int allFlights = calc[1]; //this is the calculation to get the comparison
            float y = (float)interstateFlights/allFlights;
            DecimalFormat df = new DecimalFormat("#.000");
            String withThreeDigits = df.format(y); // copied from the query 8 instructions

            if(!withThreeDigits.equals(".000")){ // removes entry of all 0's
                result.add(state + "=" + withThreeDigits); //adds to hashmap
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        Iterable<String> rs = Query8(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
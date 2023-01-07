import java.io.IOException;
import java.util.*;

public class Query7 {
    public static Iterable<String> Query7(Iterable<FlightRecord> input) {
        HashSet<String> states = new HashSet<>();
        HashSet<String> toIA = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        //this query is to find what states are not reachable from IA in one flight
        for(FlightRecord cid: input){ states.add(cid.DEST_STATE_ABR); } //store all states

        for(FlightRecord cid: input){
            if(cid.ORIGIN_STATE_ABR.equals("IA") ){ toIA.add(cid.DEST_STATE_ABR); }
        }

        for(String i: states){
            if(!toIA.contains(i)){ result.add(i); }
        } // add all the states that are not in toIA

        return result;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        Iterable<String> rs = Query7(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
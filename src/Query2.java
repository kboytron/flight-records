import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Query2 {

    public static Iterable<String> Query2(Iterable<FlightRecord> input) {
        Set<String> destination = new HashSet<>();

        //this query checks all the possible destinations from cid in one flight (no connections)
        for(FlightRecord cid : input){
            if(cid.ORIGIN.equals("CID")){
                destination.add(cid.DEST + ", " + cid.DEST_STATE_ABR);
            }
        }
        return destination;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query2(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}

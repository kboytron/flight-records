import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Query2 {

    public static Iterable<String> Query2(Iterable<FlightRecord> input) {
        Set<String> dest = new HashSet<>();

        for(FlightRecord cid : input){
            if(cid.ORIGIN.equals("CID")){
                dest.add(cid.DEST + ", " + cid.DEST_STATE_ABR);
            }
        }
        return dest;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query2(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}

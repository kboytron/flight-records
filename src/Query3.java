import java.io.IOException;
import java.util.*;

public class Query3 {

    public static int Query3(Iterable<FlightRecord> input) {
        Set<String> dest = new HashSet<>();

        //this query asks for the number of distinct destinations reachable by one flight from CID
        for(FlightRecord cid : input)
        {
            if(cid.ORIGIN.equals("CID")){ dest.add(cid.DEST); }
        }
        return dest.size();
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        int results = Query3(input);
        System.out.println(results);
    }
}

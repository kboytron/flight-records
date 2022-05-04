import java.io.IOException;
import java.util.*;

public class Query5 {
    public static String Query5(Iterable<FlightRecord> input) {
        Map<Integer, Integer> month = new HashMap<>();

        for(FlightRecord cid : input){
            month.merge(cid.MONTH, 1, Integer::sum);
            //System.out.println(month.entrySet() + "=" + month.keySet());
        }
        Map.Entry<Integer, Integer> max = null;
        for(Map.Entry<Integer, Integer> entry : month.entrySet()){
            if(max == null || max.getValue() < entry.getValue()){
                max = entry;
            }

        }
        String mans = null;
        if (max != null) {
            mans = max.getKey().toString();
        }
        String ans = null;
        if (max != null) {
            ans = max.getValue().toString();
        }

        return mans + " had " + ans + " flights";
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query5(input);
        System.out.println(r);
    }
}

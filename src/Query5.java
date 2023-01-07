import java.io.IOException;
import java.util.*;

public class Query5 {
    public static String Query5(Iterable<FlightRecord> input) {
        Map<Integer, Integer> month = new HashMap<>();

        //this query is to find which month had the most flights.

        for(FlightRecord cid : input){ month.merge(cid.MONTH, 1, Integer::sum); }
        Map.Entry<Integer, Integer> max = null;
        for(Map.Entry<Integer, Integer> entry : month.entrySet()){
            if(max == null || max.getValue() < entry.getValue()){ max = entry; }
        }
        String maxMonth = null;
        String maxNum = null;
        if (max != null) {
            maxMonth = max.getKey().toString();
            maxNum = max.getValue().toString();
        }
        return maxMonth + " had " + maxNum + " flights";
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query5(input);
        System.out.println(r);
    }
}

import java.io.IOException;

public class Query1 {

    public static int Query1(Iterable<FlightRecord> input) {
        int count = 0;

        //this query counts how many flights went out of CID
        for(FlightRecord f : input){
            if(f.ORIGIN.equals("CID")){ count++; }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        int total = Query1(input);
        System.out.println(total);
    }
}

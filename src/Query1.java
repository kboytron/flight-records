import java.io.IOException;

public class Query1 {

    public static int Query1(Iterable<FlightRecord> input) {
        int count = 0;

        //Iterator<FlightRecord> iter = input.iterator();



        for(FlightRecord CID : input){
            if(CID.ORIGIN.equals("CID")){ count++; }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        int total = Query1(input);
        System.out.println(total);
    }
}

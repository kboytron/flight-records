import java.io.IOException;
import java.util.function.Function;

public class Query1 extends AbstractQuery<Integer> {

    public Query1(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Integer execute() {
        Iterable<FlightRecord> cid = Filter.filter(input, new Query1.isCid());
        return Count.count(cid);
    }


    private static class isCid implements Function<FlightRecord, Boolean>{
        @Override
        public Boolean apply(FlightRecord r){
            return r.ORIGIN.equals("CID");
        }
    }
    public static void main(String[] args) throws IOException {
        int total = new Query1("flights1990.csv").execute();
        System.out.println(total);
    }
}

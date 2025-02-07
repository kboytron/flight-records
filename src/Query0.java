import java.io.IOException;
import java.util.function.Function;

public class Query0 extends AbstractQuery<Integer> {

    public Query0(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Integer execute() {
        Iterable<FlightRecord> laxToOrdInAugust = Filter.filter(input, new IsLaxToOrdInAugust());
        return Count.count(laxToOrdInAugust);
    }

    private static class IsLaxToOrdInAugust implements Function<FlightRecord, Boolean> {
        @Override
        public Boolean apply(FlightRecord r) {
            return r.ORIGIN.equals("LAX") && r.DEST.equals("ORD") && r.MONTH == 8;
        }
    }

    public static void main(String[] args) throws IOException {
        int result = new Query0("flights2005.csv").execute();
        System.out.println(result);
    }
}

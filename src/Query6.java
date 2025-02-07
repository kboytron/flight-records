import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

public class Query6 extends AbstractQuery<String> {

    public Query6(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        String r = new Query6("flights1990.csv").execute();
        System.out.println(r);
    }
    private static class str implements Function<FlightRecord, String> {
        @Override
        public String apply(FlightRecord t) {
            return t.ORIGIN_STATE_ABR + "," + t.DEST_STATE_ABR;
        }
    }

    @Override
    public String execute() {
        Iterable<String> cid = Transform.transform(input, new Query6.str());
        Map<String, Integer> m = CountBy.countBy(cid);
        Map.Entry<String, Integer> m1 = MaxOfMap.maxOfMap(m);
        return m1.getKey();
    }
}

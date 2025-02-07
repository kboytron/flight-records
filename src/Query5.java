import java.io.IOException;
import java.util.function.Function;
import java.util.Map;

public class Query5 extends AbstractQuery<String> {

    public Query5(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        String r = new Query5("flights2005.csv").execute();
        System.out.println(r);
    }


    @Override
    public String execute() {
        Iterable<Integer> month = Transform.transform(input, new Query5.str());
        Map<Integer, Integer> m1 = CountBy.countBy(month);
        Map.Entry<Integer,Integer> result = MaxOfMap.maxOfMap(m1);
        return result.getKey().toString() + " had " + result.getValue().toString() + " flights";

    }
    private static class str implements Function<FlightRecord, Integer> {
        @Override
        public Integer apply(FlightRecord t) { return t.MONTH; }
    }

}

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Query4 extends AbstractQuery<Iterable<String>> {

    public Query4(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Iterable<String> execute() {
        Iterable<FlightRecord> cid = Filter.filter(input, new Query4.isCid());
        Iterable<String> dis = Transform.transform(cid, new Query4.str());
        Map<String, Integer> map = CountBy.countBy(dis);
        return trans(map);
    }

    private Iterable<String> trans(Map<String,Integer> m){
        Set<String> result = new HashSet<>();
        for(Map.Entry<String, Integer> m1 : m.entrySet()){ result.add(m1.getKey() + "=" + m1.getValue()); }
        return result;
    }
    private static class isCid implements Function<FlightRecord, Boolean>{
        @Override
        public Boolean apply(FlightRecord r) { return r.ORIGIN.equals("CID"); }
    }
    private static class str implements Function<FlightRecord, String>{
        @Override
        public String apply(FlightRecord t) { return t.DEST; }
    }
    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query4("flights2005.csv").execute();
        for (String s : results) { System.out.println(s); }
    }
}

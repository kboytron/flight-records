import java.io.IOException;
import java.util.function.Function;

public class Query3 extends AbstractQuery<Integer> {
    public Query3(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        int results = new Query3("flights2020.csv").execute();
        System.out.println(results);
    }

    @Override
    public Integer execute() {
        Iterable<FlightRecord> cid = Filter.filter(input, new Query3.isDest());
        Iterable<String> dis = Transform.transform(cid, new Query3.str());
        return Count.count(Distinct.distinct(dis));

    }

    private static class isDest implements Function<FlightRecord, Boolean> {
        @Override
        public Boolean apply(FlightRecord r) { return "CID".equals(r.ORIGIN); }
    }
    private static class str implements Function<FlightRecord, String>{
        @Override
        public String apply(FlightRecord t) {
            return t.DEST;
        }
    }
}

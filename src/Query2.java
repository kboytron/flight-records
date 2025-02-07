import java.io.IOException;
import java.util.function.Function;

public class Query2 extends AbstractQuery<Iterable<String>> {

    //destinations from cid
    public Query2(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Iterable<String> execute() {
        Iterable<FlightRecord> cid = Filter.filter(input, new Query2.isCid());
        Iterable<String> dis = Transform.transform(cid,new Query2.str());
        return Distinct.distinct(dis);

    }

    private static class isCid implements Function<FlightRecord,Boolean>{
        @Override
        public Boolean apply(FlightRecord r) { return "CID".equals(r.ORIGIN); }
    }
    private static class str implements Function<FlightRecord, String>{
        @Override
        public String apply(FlightRecord t) {
            return new StringBuilder(t.DEST).append(", ").append(t.DEST_STATE_ABR).toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query2("flights2005.csv").execute();
        for (String s : results) {
            System.out.println(s);
        }
    }
}

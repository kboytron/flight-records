import java.io.IOException;
import java.util.Set;
import java.util.function.Function;

public class Query7 extends AbstractQuery<Iterable<String>> {
    public Query7(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> rs = new Query7("flights1990.csv").execute();
        for (String r : rs) {
            System.out.println(r);
        }
    }

    private static class str implements Function<FlightRecord, String> {
        @Override
        public String apply(FlightRecord t) {
            return t.ORIGIN_STATE_ABR ;
        }
    }
    private static class str1 implements Function<FlightRecord, String> {
        @Override
        public String apply(FlightRecord t) {
            return t.DEST_STATE_ABR ;
        }
    }

    private static class isCid implements Function<FlightRecord, Boolean>{
        @Override
        public Boolean apply(FlightRecord r){ return r.ORIGIN_STATE_ABR.equals("IA") ; }
    }

    @Override
    public Iterable<String> execute() {
        Iterable<String> org = Transform.transform(input, new Query7.str());
        Iterable<String> dest = Transform.transform(input, new Query7.str1());
        Iterable<String> combo = Concatenate.concatenate(org,dest);
        Set<String> dis = Distinct.distinct(combo);

        Iterable<FlightRecord> fIa = Filter.filter(input, new Query7.isCid());
        Iterable<String> orgIa = Transform.transform(fIa, new Query7.str());
        Iterable<String> destIa = Transform.transform(fIa, new Query7.str1());
        Iterable<String> comboIa = Concatenate.concatenate(orgIa,destIa);
        Set<String> disIa = Distinct.distinct(comboIa);

        return Difference.difference(dis, disIa);
    }
}

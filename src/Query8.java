import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;

public class Query8 extends AbstractQuery<Iterable<String>> {
    public Query8(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query8("flights2020.csv").execute();
        for (String result : results) {
            System.out.println(result);
        }
    }

    @Override
    public Iterable<String> execute() {
        // Step 1: Filter and count all flights within the same state
        Iterable<FlightRecord> intraStateFlights = Filter.filter(input, new SameStateFilter());
        Map<String, Integer> intraStateCounts = CountBy.countBy(Transform.transform(intraStateFlights, new StateTransform()));

        // Step 2: Count all flights grouped by origin state
        Map<String, Integer> totalFlightCounts = CountBy.countBy(Transform.transform(input, new OriginStateTransform()));

        // Step 3: Join the two maps
        Map<String, Pair<Integer, Integer>> joinedCounts = MapJoin.mapJoin(totalFlightCounts, intraStateCounts);

        // Step 4: Calculate percentages and format the output
        return Transform.transform(joinedCounts.entrySet(), new PercentageFormatter());
    }

    // Filter to keep only flights within the same state
    private static class SameStateFilter implements java.util.function.Function<FlightRecord, Boolean> {
        @Override
        public Boolean apply(FlightRecord record) {
            return record.ORIGIN_STATE_ABR.equals(record.DEST_STATE_ABR);
        }
    }

    // Transformation to extract the state from a flight record
    private static class StateTransform implements java.util.function.Function<FlightRecord, String> {
        @Override
        public String apply(FlightRecord record) {
            return record.ORIGIN_STATE_ABR;
        }
    }

    // Transformation to extract the origin state from a flight record
    private static class OriginStateTransform implements java.util.function.Function<FlightRecord, String> {
        @Override
        public String apply(FlightRecord record) {
            return record.ORIGIN_STATE_ABR;
        }
    }

    // Formatter to calculate and display percentages with 3 decimal places
    private static class PercentageFormatter implements java.util.function.Function<Map.Entry<String, Pair<Integer, Integer>>, String> {
        private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.000");

        @Override
        public String apply(Map.Entry<String, Pair<Integer, Integer>> entry) {
            String state = entry.getKey();
            Pair<Integer, Integer> counts = entry.getValue();
            int totalFlights = counts.first;
            int intraStateFlights = counts.second;

            // Calculate percentage
            double percentage = (double) intraStateFlights / totalFlights;

            // Format and return the result string
            return state + "=" + DECIMAL_FORMAT.format(percentage);
        }
    }
}

import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class Query10 extends AbstractQuery<Iterable<String>> {

    public Query10(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query10("flights2020.csv").execute();
        for (String result : results) {
            System.out.println(result);
        }
    }

    @Override
    public Iterable<String> execute() {
        // Step 1: Filter flights starting from CID
        Iterable<FlightRecord> fromCID = Filter.filter(input, r -> r.ORIGIN.equals("CID"));

        // Step 2: Filter flights ending at LAX
        Iterable<FlightRecord> toLAX = Filter.filter(input, r -> r.DEST.equals("LAX"));

        // Step 3: Group flights by their destination (from CID)
        Map<String, List<FlightRecord>> groupedByDest = GroupBy.groupBy(fromCID, r -> r.DEST);

        // Step 4: Group flights by their origin (to LAX)
        Map<String, List<FlightRecord>> groupedByOrigin = GroupBy.groupBy(toLAX, r -> r.ORIGIN);

        // Step 5: Join the two maps based on the layover
        Map<String, Pair<List<FlightRecord>, List<FlightRecord>>> joinedFlights = MapJoin.mapJoin(groupedByDest, groupedByOrigin);

        // Step 6: Transform the joined flights into route strings
        Iterable<Iterable<String>> transformedRoutes = Transform.transform(joinedFlights.entrySet(), new RouteTransform());

        // Step 7: Flatten and return distinct routes
        return Distinct.distinct(Flatten.flatten(transformedRoutes));
    }

    // Transformation class to generate route strings
    private static class RouteTransform implements Function<Map.Entry<String, Pair<List<FlightRecord>, List<FlightRecord>>>, Iterable<String>> {
        @Override
        public Iterable<String> apply(Map.Entry<String, Pair<List<FlightRecord>, List<FlightRecord>>> entry) {
            List<String> routes = new ArrayList<>();
            List<FlightRecord> firstLegs = entry.getValue().first;  // Flights from CID to layover
            List<FlightRecord> secondLegs = entry.getValue().second; // Flights from layover to LAX

            // Generate routes by combining matching flights
            for (FlightRecord first : firstLegs) {
                for (FlightRecord second : secondLegs) {
                    routes.add(first.ORIGIN + "->" + first.DEST + "->" + second.DEST);
                }
            }

            return routes;
        }
    }
}

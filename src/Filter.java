import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Filter {
    public static Iterable<FlightRecord> filter(Iterable<FlightRecord> input, Function<FlightRecord, Boolean> condition) {
        // will put the records that meet the condition in here
        List<FlightRecord> result = new LinkedList<>();

        // iterate through all records in the input
        for (FlightRecord r : input) {
            // if the record meets the condition, then...
            if (condition.apply(r)) {
                // ...add it to the list
                result.add(r);
            }
        }
        return result;
    }
}

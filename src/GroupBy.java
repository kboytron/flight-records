import java.util.*;
import java.util.function.Function;

public class GroupBy {

    public static <K, E> Map<K, List<E>> groupBy(Iterable<E> input, Function<E, K> extractKey) {
        Map<K, List<E>> result = new HashMap<>();

        // Iterate through each element in the input iterable
        for (E element : input) {
            // Extract the key using the provided function
            K key = extractKey.apply(element);

            // Add the element to the appropriate list in the map
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(element);
        }

        return result;
    }
}

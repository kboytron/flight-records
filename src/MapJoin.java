import java.util.HashMap;
import java.util.Map;

public class MapJoin {
    public static <K, V1, V2> Map<K, Pair<V1, V2>> mapJoin(Map<K, V1> m1, Map<K, V2> m2) {
        Map<K, Pair<V1, V2>> result = new HashMap<>();

        // Iterate over keys in m1 and check if the key exists in m2
        for (K key : m1.keySet()) {
            if (m2.containsKey(key)) {
                // Create and store a Pair object with values from both maps
                result.put(key, new Pair<>(m1.get(key), m2.get(key)));
            }
        }

        return result;
    }
}

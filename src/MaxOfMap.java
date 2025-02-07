import java.util.Map;

public class MaxOfMap {
    public static <K> Map.Entry<K,Integer> maxOfMap(Map<K, Integer> input) {
        Map.Entry<K, Integer> result = null;
        for(Map.Entry<K, Integer> m : input.entrySet()){
            if(result == null || result.getValue() < m.getValue()){ result = m; }
        }
        return result;
    }
}

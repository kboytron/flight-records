import java.util.HashMap;
import java.util.Map;

public class CountBy {
    public static <E> Map<E, Integer> countBy(Iterable<E> input) {
        Map<E, Integer> result = new HashMap<>();

        for(E r: input){
            if(result.containsKey(r)){
                result.put(r, result.get(r)+1);
            }
            else{ result.put(r,1); }
        }
        return result;
    }
}

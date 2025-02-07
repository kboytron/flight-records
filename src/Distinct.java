import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static <E> Set<E> distinct(Iterable<E> input) {
        Set<E> result = new HashSet<>();

        for(E r : input){
            result.add(r);
        }
        return result;
    }
}

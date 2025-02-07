import java.util.HashSet;
import java.util.Set;

public class Difference {
    public static <T> Set<T> difference(Set<T> first, Set<T> second) {
        HashSet<T> result = new HashSet<>();
        for(T m : first) {
            if (!second.contains(m)) { result.add(m); }
        }
        return result;
    }
}

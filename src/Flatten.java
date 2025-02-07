import java.util.*;

public class Flatten {
    public static <E> Iterable<E> flatten(Iterable<Iterable<E>> input) {
        List<E> result = new ArrayList<>();

        for (Iterable<E> inner : input) {
            for (E element : inner) {
                result.add(element);
            }
        }

        return result;
    }
}

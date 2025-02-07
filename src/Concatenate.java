import java.util.ArrayList;

public class Concatenate {
    public static <E> Iterable<E> concatenate(Iterable<E> first, Iterable<E> second) {
        ArrayList<E> result = new ArrayList<>();
        for(E m : first){ result.add(m); }
        for(E m1 : second){ result.add(m1); }

        return result;
    }
}

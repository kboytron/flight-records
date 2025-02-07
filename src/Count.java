public class Count<E> {
    public static <E> int count(Iterable<E> list) {
        int c = 0;
        for (E e : list) {
            c++;
        }
        return c;
    }
}

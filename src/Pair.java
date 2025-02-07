public class Pair<F, S> {
    public final F first;
    public final S second;

    @Override
    public String toString() {
        return "Pair{" +
                "" + first +
                "," + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair that = (Pair) o;
            return first.equals(that.first) && second.equals(that.second);
        } else {
            return false;
        }
    }

    public Pair(F f, S s) {
        first = f;
        second = s;
    }
}

public interface Query<R> extends Comparable<Query<R>> {
    public String name();
    public String filename();
    public R execute();
}

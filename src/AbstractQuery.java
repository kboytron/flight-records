import java.io.IOException;
import java.util.Objects;

public abstract class AbstractQuery<R> implements Query<R>, Comparable<Query<R>> {
    protected final Iterable<FlightRecord> input;
    private final String filename;

    public AbstractQuery(String filename) throws IOException {
        this.filename = filename;
        this.input = DataImporter.getData(filename);
    }

    @Override
    public final String name() {
        return this.getClass().getName();
    }

    @Override
    public final String filename() {
        return this.filename;
    }

    @Override
    public String toString() {
        return this.name() + " on " + this.filename;
    }

    // Override equals to check both the filename and name of the query
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false;  // Different class

        AbstractQuery<?> that = (AbstractQuery<?>) obj;
        return Objects.equals(this.filename, that.filename) &&
                Objects.equals(this.name(), that.name());
    }

    // Override hashCode to be consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(this.filename, this.name());
    }

    // Implement compareTo for TreeMap usage (consistent with equals)
    @Override
    public int compareTo(Query<R> that) {
        // Compare by filename first, then by name
        int filenameComparison = this.filename.compareTo(that.filename());
        if (filenameComparison != 0) return filenameComparison;

        return this.name().compareTo(that.name());
    }
}

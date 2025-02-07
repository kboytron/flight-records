import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class QueryExecutor<R> {
    private final Map<Query<R>, R> cache;

    public QueryExecutor(boolean useHashMap) {
        if (useHashMap) cache = new HashMap<>();
        else cache = new TreeMap<>();
    }

    public R runQuery(Query<R> q) {
        Timer t = new Timer();
        t.start();

        boolean wasCached = true;
        R result = cache.get(q);
        if (result == null) {
            // run the query
            result = q.execute();
            cache.put(q, result);
            wasCached = false;
        }
        t.end();
        if (wasCached) {
            System.out.println(q.toString() + " took " + t.elapsedSeconds() + " seconds (found in cache)");
        } else {
            System.out.println(q.toString() + " took " + t.elapsedSeconds() + " seconds (executed)");
        }
        return result;
    }

    public static void benchmark(QueryExecutor<Integer> intQE,
                                QueryExecutor<String> stringQE,
                                QueryExecutor<Iterable<String>> iterableQE) throws IOException {
        String data90 = "flights1990.csv";
        String data05 = "flights2005.csv";
        String data20 = "flights2020.csv";

        intQE.runQuery(new Query0(data90));
        intQE.runQuery(new Query0(data90));
        intQE.runQuery(new Query0(data05));
        intQE.runQuery(new Query0(data05));
        intQE.runQuery(new Query0(data20));
        intQE.runQuery(new Query0(data20));
        intQE.runQuery(new Query1(data90));
        intQE.runQuery(new Query1(data90));
        intQE.runQuery(new Query1(data05));
        intQE.runQuery(new Query1(data05));
        intQE.runQuery(new Query1(data20));
        intQE.runQuery(new Query1(data20));

        stringQE.runQuery(new Query5(data90));
        stringQE.runQuery(new Query5(data90));
        stringQE.runQuery(new Query5(data05));
        stringQE.runQuery(new Query5(data05));
        stringQE.runQuery(new Query5(data20));
        stringQE.runQuery(new Query5(data20));
        stringQE.runQuery(new Query6(data90));
        stringQE.runQuery(new Query6(data90));
        stringQE.runQuery(new Query6(data05));
        stringQE.runQuery(new Query6(data05));
        stringQE.runQuery(new Query6(data20));
        stringQE.runQuery(new Query6(data20));

        iterableQE.runQuery(new Query2(data90));
        iterableQE.runQuery(new Query2(data90));
        iterableQE.runQuery(new Query2(data05));
        iterableQE.runQuery(new Query2(data05));
        iterableQE.runQuery(new Query2(data20));
        iterableQE.runQuery(new Query2(data20));
        iterableQE.runQuery(new Query4(data90));
        iterableQE.runQuery(new Query4(data90));
        iterableQE.runQuery(new Query4(data05));
        iterableQE.runQuery(new Query4(data05));
        iterableQE.runQuery(new Query4(data20));
        iterableQE.runQuery(new Query4(data20));
        iterableQE.runQuery(new Query7(data90));
        iterableQE.runQuery(new Query7(data90));
        iterableQE.runQuery(new Query7(data05));
        iterableQE.runQuery(new Query7(data05));
        iterableQE.runQuery(new Query7(data20));
        iterableQE.runQuery(new Query7(data20));
        iterableQE.runQuery(new Query8(data90));
        iterableQE.runQuery(new Query8(data90));
        iterableQE.runQuery(new Query8(data05));
        iterableQE.runQuery(new Query8(data05));
        iterableQE.runQuery(new Query8(data20));
        iterableQE.runQuery(new Query8(data20));
        iterableQE.runQuery(new Query10(data90));
        iterableQE.runQuery(new Query10(data90));
        iterableQE.runQuery(new Query10(data05));
        iterableQE.runQuery(new Query10(data05));
        iterableQE.runQuery(new Query10(data20));
        iterableQE.runQuery(new Query10(data20));
    }

    public static void main(String[] args) throws IOException {
        // Since caching requires a lot of memory for storing results,
        // for fun we can print the memory usage at different points
        printMemoryUsage();
        {
            // run all queries while using a HashMap for the cache
            System.out.println("HashMap cache");
            QueryExecutor<Integer> intQE = new QueryExecutor<>(true);
            QueryExecutor<String> stringQE = new QueryExecutor<>(true);
            QueryExecutor<Iterable<String>> iterableQE = new QueryExecutor<>(true);
            benchmark(intQE, stringQE, iterableQE);
            printMemoryUsage();
        }

        {
            // run all queries while using a TreeMap for the cache
            System.out.println("TreeMap cache");
            QueryExecutor<Integer> intQE = new QueryExecutor<>(false);
            QueryExecutor<String> stringQE = new QueryExecutor<>(false);
            QueryExecutor<Iterable<String>> iterableQE = new QueryExecutor<>(false);
            benchmark(intQE, stringQE, iterableQE);
            printMemoryUsage();
        }
    }

    private static void printMemoryUsage() {
        double freeMB = (double)Runtime.getRuntime().freeMemory() / (1000*1000);
        double totalMB = (double)Runtime.getRuntime().totalMemory() / (1000*1000);
        System.out.println(freeMB + "MB available of " + totalMB + "MB");
    }
}

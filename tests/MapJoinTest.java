import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class MapJoinTest {
    @Test
    public void testEmptyResult() {
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("e", 2);
        a.put("f", 3);

        Map<String, String> b = new TreeMap<>();
        b.put("b", "balloon");
        b.put("c", "cat");
        b.put("d", "dog");

        {
            Map<String, Pair<Integer, String>> expected = new TreeMap<>();
            Map<String, Pair<Integer, String>> joined = MapJoin.mapJoin(a, b);
            Assert.assertEquals(expected, joined);
        }
        {
            Map<String, Pair<String, Integer>> expected = new TreeMap<>();
            Map<String, Pair<String, Integer>> joined = MapJoin.mapJoin(b, a);
            Assert.assertEquals(expected, joined);
        }
    }
    @Test
    public void test1() {
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("b", 2);
        a.put("c", 3);

        Map<String, String> b = new TreeMap<>();
        b.put("b", "balloon");
        b.put("c", "cat");
        b.put("d", "dog");

        {
            Map<String, Pair<Integer, String>> expected = new TreeMap<>();
            expected.put("b", new Pair<>(2, "balloon"));
            expected.put("c", new Pair<>(3, "cat"));
            Map<String, Pair<Integer,String>> joined = MapJoin.mapJoin(a, b);
            Assert.assertEquals(expected, joined);
        }
        {
            Map<String, Pair<String, Integer>> expected = new TreeMap<>();
            expected.put("b", new Pair<>( "balloon", 2));
            expected.put("c", new Pair<>( "cat", 3));
            Map<String, Pair<String,Integer>> joined = MapJoin.mapJoin(b, a);
            Assert.assertEquals(expected, joined);
        }

    }

}
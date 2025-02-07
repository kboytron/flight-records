import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxOfMapTest {
    @Test
    public void test1() {
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("e", 2);
        a.put("f", 3);

        // silly way of getting ("f", 3) as a Map.Entry
        Map<String, Integer> ex = new HashMap<>();
        ex.put("f", 3);
        Map.Entry<String,Integer> expected = ex.entrySet().iterator().next();

        Assert.assertEquals(expected, MaxOfMap.maxOfMap(a));
    }
    @Test
    public void test2() {
        Map<String, Integer> a = new HashMap<>();
        a.put("a", 1);
        a.put("b", 15);
        a.put("e", 2);
        a.put("f", 3);
        a.put("c", 10);

        // silly way of getting ("b", 15) as a Map.Entry
        Map<String, Integer> ex = new HashMap<>();
        ex.put("b", 15);
        Map.Entry<String,Integer> expected = ex.entrySet().iterator().next();

        Assert.assertEquals(expected, MaxOfMap.maxOfMap(a));
    }
}
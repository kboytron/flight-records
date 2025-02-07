import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CountByTest {
    @Test
    public void testEmpty() {
        List<Integer> input = new LinkedList<>();
        Assert.assertEquals(new HashMap<Integer,Integer>(), CountBy.countBy(input));
        // input should not have been modified
        Assert.assertTrue(input.isEmpty());
    }

    @Test
    public void testString() {
        String[] a = {"a", "g", "z", "d", "w", "w", "w", "q", "a", "w"};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);
        Map<String, Integer> expected = new TreeMap<>();
        expected.put("a", 2);
        expected.put("g", 1);
        expected.put("z", 1);
        expected.put("d", 1);
        expected.put("w", 4);
        expected.put("q", 1);
        Assert.assertEquals(expected, CountBy.countBy(input));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testInteger() {
        Integer[] a = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        List<Integer> input = Arrays.asList(a);
        List<Integer> inputCopy = new LinkedList<>(input);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(10, 3);
        expected.put(44, 2);
        expected.put(50, 1);
        expected.put(2, 1);
        expected.put(1, 2);
        expected.put(0, 2);
        expected.put(33, 1);
        Assert.assertEquals(expected, CountBy.countBy(input));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }
}
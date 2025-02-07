import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DistinctTest {
    @Test
    public void testEmpty() {
        String[] a = {};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);
        String[] ex = {};
        Set<String> expected = new HashSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Distinct.distinct(input));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testString() {
        String[] a = {"a", "g", "z", "d", "w", "w", "w", "q", "a", "w"};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);
        String[] ex = {"a", "g", "z", "d", "w", "q"};
        Set<String> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Distinct.distinct(input));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testInteger() {
        Integer[] a = {10, 15, 16, 33, 100, 15, 10, 1, 0, 15};
        List<Integer> input = Arrays.asList(a);
        List<Integer> inputCopy = new LinkedList<>(input);
        Integer[] ex = {10, 15, 16, 33, 100, 1, 0};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Distinct.distinct(input));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FlattenTest {
    @Test
    public void testEmptyOuter() {
        List<Iterable<Integer>> input = new LinkedList<>();
        Assert.assertEquals(new LinkedList<>(), Flatten.flatten(input));
        // input should not have been modified
        Assert.assertTrue(input.isEmpty());
    }
    @Test
    public void testEmptyInners() {
        List<Iterable<String>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.add(new ArrayList<>());
        input.add(new LinkedList<>());

        List<Iterable<String>> inputCopy = new LinkedList<>();
        inputCopy.add(new LinkedList<>());
        inputCopy.add(new ArrayList<>());
        inputCopy.add(new LinkedList<>());

        Assert.assertEquals(new ArrayList<>(), Flatten.flatten(input));
        // input should not have been modified
        Assert.assertEquals(inputCopy, input);
    }

    @Test
    public void testDifferent() {
        List<Iterable<String>> input = new ArrayList<>();
        String[] l1 = {"a","b","c"};
        input.add(Arrays.asList(l1));
        input.add(new ArrayList<>());
        String[] l2 = {"a","b","c","d","e","f"};
        input.add(Arrays.asList(l2));
        input.add(new LinkedList<>());

        List<Iterable<String>> inputCopy = new LinkedList<>();
        inputCopy.add(Arrays.asList(l1));
        inputCopy.add(new ArrayList<>());
        inputCopy.add(Arrays.asList(l2));
        inputCopy.add(new ArrayList<>());

        String[] ex = {"a","b","c","a","b","c","d","e","f"};
        List<String> expected = Arrays.asList(ex);

        Assert.assertEquals(expected, Flatten.flatten(input));
        // input should not have been modified
        Assert.assertEquals(inputCopy, input);
    }

}
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DifferenceTest {
    @Test
    public void testDisjoint() {
        Integer[] a = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Integer[] b = {100, 200, 100, 300, 400, 100, 600};
        Set<Integer> inputA = new HashSet<>(Arrays.asList(a));
        Set<Integer> inputCopyA = new HashSet<>(inputA);
        Set<Integer> inputB = new TreeSet<>(Arrays.asList(b));
        Set<Integer> inputCopyB = new TreeSet<>(inputB);

        Integer[] ex = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Difference.difference(inputA, inputB));
        // input should not have been modified
        Assert.assertEquals(inputA, inputCopyA);
        Assert.assertEquals(inputB, inputCopyB);
    }

    @Test
    public void testIdentical() {
        Integer[] a = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Integer[] b = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Set<Integer> inputA = new HashSet<>(Arrays.asList(a));
        Set<Integer> inputCopyA = new HashSet<>(inputA);
        Set<Integer> inputB = new TreeSet<>(Arrays.asList(b));
        Set<Integer> inputCopyB = new TreeSet<>(inputB);

        Integer[] ex = {};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Difference.difference(inputA, inputB));
        // input should not have been modified
        Assert.assertEquals(inputA, inputCopyA);
        Assert.assertEquals(inputB, inputCopyB);
    }

    @Test
    public void test1() {
        Integer[] a = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Integer[] b = {10, 50, 33, 44, 10, 10, 0};
        Set<Integer> inputA = new HashSet<>(Arrays.asList(a));
        Set<Integer> inputCopyA = new HashSet<>(inputA);
        Set<Integer> inputB = new TreeSet<>(Arrays.asList(b));
        Set<Integer> inputCopyB = new TreeSet<>(inputB);

        Integer[] ex = {1, 2};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Difference.difference(inputA, inputB));
        // input should not have been modified
        Assert.assertEquals(inputA, inputCopyA);
        Assert.assertEquals(inputB, inputCopyB);
    }

    @Test
    public void testEmptyFirst() {
        Integer[] a = {};
        Integer[] b = {10, 50, 33, 44, 10, 10, 0};
        Set<Integer> inputA = new HashSet<>(Arrays.asList(a));
        Set<Integer> inputCopyA = new HashSet<>(inputA);
        Set<Integer> inputB = new TreeSet<>(Arrays.asList(b));
        Set<Integer> inputCopyB = new TreeSet<>(inputB);

        Integer[] ex = {};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Difference.difference(inputA, inputB));
        // input should not have been modified
        Assert.assertEquals(inputA, inputCopyA);
        Assert.assertEquals(inputB, inputCopyB);
    }

    @Test
    public void testEmptySecond() {
        Integer[] a = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Integer[] b = {};
        Set<Integer> inputA = new HashSet<>(Arrays.asList(a));
        Set<Integer> inputCopyA = new HashSet<>(inputA);
        Set<Integer> inputB = new TreeSet<>(Arrays.asList(b));
        Set<Integer> inputCopyB = new TreeSet<>(inputB);

        Integer[] ex = {10, 44, 50, 33, 2, 1, 0, 1, 44, 10, 10, 0};
        Set<Integer> expected = new TreeSet<>(Arrays.asList(ex));
        Assert.assertEquals(expected, Difference.difference(inputA, inputB));
        // input should not have been modified
        Assert.assertEquals(inputA, inputCopyA);
        Assert.assertEquals(inputB, inputCopyB);
    }

}
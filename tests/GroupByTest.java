import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class GroupByTest {
    @Test
    public void testEmptyAndKeyIsIdentity() {
        List<Integer> input = new LinkedList<>();
        Map<Integer,List<Integer>> expected = new HashMap<>();
        Assert.assertEquals(expected, GroupBy.groupBy(input, new Identity<>()));
        // input should not have been modified
        Assert.assertTrue(input.isEmpty());
    }

    @Test
    public void testKeyIsIdentity() {
        String[] a = {"a", "g", "z", "d", "w", "w", "w", "q", "a", "w"};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);

        Map<String, List<String>> expected = new TreeMap<>();
        String[] al = {"a","a"};
        String[] gl = {"g"};
        String[] zl = {"z"};
        String[] dl = {"d"};
        String[] wl = {"w", "w", "w", "w"};
        String[] ql = {"q"};
        expected.put("a", Arrays.asList(al));
        expected.put("g", Arrays.asList(gl));
        expected.put("z", Arrays.asList(zl));
        expected.put("d", Arrays.asList(dl));
        expected.put("w", Arrays.asList(wl));
        expected.put("q", Arrays.asList(ql));
        Assert.assertEquals(expected, GroupBy.groupBy(input, new Identity<>()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testKeyIsAddOne() {
        Integer[] a = {55, 67, 29, 101, 220, 220, 220, 17, 55, 220};
        List<Integer> input = Arrays.asList(a);
        List<Integer> inputCopy = new LinkedList<>(input);

        Map<Integer, List<Integer>> expected = new TreeMap<>();
        Integer[] al = {55,55};
        Integer[] gl = {67};
        Integer[] zl = {29};
        Integer[] dl = {101};
        Integer[] wl = {220, 220, 220, 220};
        Integer[] ql = {17};
        expected.put(56, Arrays.asList(al));
        expected.put(68, Arrays.asList(gl));
        expected.put(30, Arrays.asList(zl));
        expected.put(102, Arrays.asList(dl));
        expected.put(221, Arrays.asList(wl));
        expected.put(18, Arrays.asList(ql));
        Assert.assertEquals(expected, GroupBy.groupBy(input, new AddOne()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testKeyIsSecondOfPair() {
        List<Pair<Integer,Integer>> input = new ArrayList<>();
        input.add(new Pair(4, 10));
        input.add(new Pair(12, 100));
        input.add(new Pair(4, 20));
        input.add(new Pair(20, 10));
        List<Pair<Integer,Integer>> inputCopy = new LinkedList<>(input);

        Map<Integer, List<Pair<Integer,Integer>>> expected = new TreeMap<>();

        List<Pair<Integer,Integer>> al = new ArrayList<>();
        List<Pair<Integer,Integer>> bl = new ArrayList<>();
        List<Pair<Integer,Integer>> cl = new ArrayList<>();
        al.add(new Pair(4, 10));
        al.add(new Pair(20, 10));
        bl.add(new Pair(12, 100));
        cl.add(new Pair(4, 20));
        expected.put(10, al);
        expected.put(100, bl);
        expected.put(20, cl);
        Assert.assertEquals(expected, GroupBy.groupBy(input, new GetSecond<>()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testKeyIsFirstOfPair() {
        List<Pair<Integer,Integer>> input = new ArrayList<>();
        input.add(new Pair(4, 10));
        input.add(new Pair(12, 100));
        input.add(new Pair(4, 20));
        input.add(new Pair(20, 10));
        List<Pair<Integer,Integer>> inputCopy = new LinkedList<>(input);

        Map<Integer, List<Pair<Integer,Integer>>> expected = new TreeMap<>();

        List<Pair<Integer,Integer>> al = new ArrayList<>();
        List<Pair<Integer,Integer>> bl = new ArrayList<>();
        List<Pair<Integer,Integer>> cl = new ArrayList<>();
        al.add(new Pair(4, 10));
        al.add(new Pair(4, 20));
        bl.add(new Pair(12, 100));
        cl.add(new Pair(20, 10));
        expected.put(4, al);
        expected.put(12, bl);
        expected.put(20, cl);
        Assert.assertEquals(expected, GroupBy.groupBy(input, new GetFirst<>()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    private static class Identity<E> implements Function<E, E> {
        @Override
        public E apply(E i) {
            return i;
        }
    }

    private static class AddOne implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer i) {
            return i+1;
        }
    }

    private static class GetSecond<F,S> implements Function<Pair<F,S>, S> {
        @Override
        public S apply(Pair<F, S> p) {
            return p.second;
        }
    }
    private static class GetFirst<F,S> implements Function<Pair<F,S>, F> {
        @Override
        public F apply(Pair<F, S> p) {
            return p.first;
        }
    }
}
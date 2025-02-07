import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class TransformTest {
    @Test
    public void testEmpty() {
        String[] a = {};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);
        String[] ex = {};
        List<String> expected = Arrays.asList(ex);
        Assert.assertEquals(expected, Transform.transform(input, new StringLength()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testStringLength() {
        String[] a = {"abcd", "efghi", "j", "k", "lmnopqr"};
        List<String> input = Arrays.asList(a);
        List<String> inputCopy = new LinkedList<>(input);
        Integer[] ex = {4, 5, 1, 1, 7};
        List<Integer> expected = Arrays.asList(ex);
        Assert.assertEquals(expected, Transform.transform(input, new StringLength()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testFirstOfPairs() {
        List<Pair<Integer,Integer>> input = new LinkedList<>();
        input.add(new Pair(4, 10));
        input.add(new Pair(12, 100));
        input.add(new Pair(4, 20));
        input.add(new Pair(20, 10));
        List<Pair<Integer,Integer>> inputCopy = new LinkedList<>(input);

        Integer[] ex = {4, 12, 4, 20};
        List<Integer> expected = Arrays.asList(ex);

        Assert.assertEquals(expected, Transform.transform(input, new GetFirst<>()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    @Test
    public void testSecondOfPairs() {
        List<Pair<Integer,Integer>> input = new LinkedList<>();
        input.add(new Pair(4, 10));
        input.add(new Pair(12, 100));
        input.add(new Pair(4, 20));
        input.add(new Pair(20, 10));
        List<Pair<Integer,Integer>> inputCopy = new LinkedList<>(input);

        Integer[] ex = {10, 100, 20, 10};
        List<Integer> expected = Arrays.asList(ex);

        Assert.assertEquals(expected, Transform.transform(input, new GetSecond<>()));
        // input should not have been modified
        Assert.assertEquals(input, inputCopy);
    }

    private static class StringLength implements Function<String, Integer> {
        @Override
        public Integer apply(String s) {
            return s.length();
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
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ConcatenateTest {
    @Test
    public void testEmpty() {
        List<Integer> l1 = new LinkedList<>();
        Set<Integer> l2 = new HashSet<>();
        Assert.assertEquals(new ArrayList<>(), Concatenate.concatenate(l1, l2));
    }

    @Test
    public void test1() {
        List<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(3);
        List<Integer> l1Copy = new LinkedList<>();
        l1Copy.add(2);
        l1Copy.add(3);

        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        List<Integer> l2Copy = new ArrayList<>();
        l2Copy.add(3);
        l2Copy.add(4);
        l2Copy.add(5);

        List<Integer> lex = new ArrayList<>();
        lex.add(2);
        lex.add(3);
        lex.add(3);
        lex.add(4);
        lex.add(5);
        Assert.assertEquals(lex, Concatenate.concatenate(l1, l2));
        // should not modify the input
        Assert.assertEquals(l1, l1Copy);
        Assert.assertEquals(l2, l2Copy);
    }

    @Test
    public void testFirstEmpty() {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l1Copy = new LinkedList<>();

        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        List<Integer> l2Copy = new ArrayList<>();
        l2Copy.add(3);
        l2Copy.add(4);
        l2Copy.add(5);

        List<Integer> lex = new ArrayList<>();
        lex.add(3);
        lex.add(4);
        lex.add(5);
        Assert.assertEquals(lex, Concatenate.concatenate(l1, l2));
        // should not modify the input
        Assert.assertEquals(l1, l1Copy);
        Assert.assertEquals(l2, l2Copy);
    }

    @Test
    public void testSecondEmpty() {
        List<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(3);
        List<Integer> l1Copy = new LinkedList<>();
        l1Copy.add(2);
        l1Copy.add(3);

        List<Integer> l2 = new LinkedList<>();
        List<Integer> l2Copy = new ArrayList<>();

        List<Integer> lex = new ArrayList<>();
        lex.add(2);
        lex.add(3);
        Assert.assertEquals(lex, Concatenate.concatenate(l1, l2));
        // should not modify the input
        Assert.assertEquals(l1, l1Copy);
        Assert.assertEquals(l2, l2Copy);
    }
}
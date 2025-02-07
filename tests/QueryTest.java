import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class QueryTest {
    @Test
    public void test0() throws IOException {
        {
            int result = new Query0("flights1990.csv").execute();
            Assert.assertEquals(2, result);
        }
        {
            int result = new Query0("flights2005.csv").execute();
            Assert.assertEquals(5, result);
        }
        {
            int result = new Query0("flights2020.csv").execute();
            Assert.assertEquals(6, result);
        }
    }

    @Test
    public void test1() throws IOException {
        {
            int total = new Query1("flights1990.csv").execute();
            Assert.assertEquals(275, total);
        }
        {
            int total = new Query1("flights2005.csv").execute();
            Assert.assertEquals(409, total);
        }
        {
            int total = new Query1("flights2020.csv").execute();
            Assert.assertEquals(444, total);
        }
    }

    @Test
    public void test2() throws IOException {
        {
            Iterable<String> results = new Query2("flights2020.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults2Col("query2_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query2("flights1990.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults2Col("query2_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query2("flights2005.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults2Col("query2_2005.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test3() throws IOException {
        {
            int result = new Query3("flights1990.csv").execute();
            Assert.assertEquals(57, result);
        }
        {
            int result = new Query3("flights2005.csv").execute();
            Assert.assertEquals(87, result);
        }
        {
            int result = new Query3("flights2020.csv").execute();
            Assert.assertEquals(63, result);
        }
    }

    @Test
    public void test4() throws IOException {
        {
            Iterable<String> results = new Query4("flights2020.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query4_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query4("flights1990.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query4_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query4("flights2005.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query4_2005.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test5() throws IOException {
        {
            String result = new Query5("flights1990.csv").execute();
            Assert.assertEquals("9 had 13832 flights", result);
        }
        {
            String result = new Query5("flights2005.csv").execute();
            Assert.assertEquals("6 had 23800 flights", result);
        }
        {
            String result = new Query5("flights2020.csv").execute();
            Assert.assertEquals("1 had 21945 flights", result);
        }
    }

    @Test
    public void test6() throws IOException {
        {
            String result = new Query6("flights1990.csv").execute();
            Assert.assertEquals("CA,CA", result);
        }
        {
            String result = new Query6("flights2005.csv").execute();
            Assert.assertEquals("AK,AK", result);
        }
        {
            String result = new Query6("flights2020.csv").execute();
            Assert.assertEquals("AK,AK", result);
        }
    }

    @Test
    public void test7() throws IOException {
        {
            Iterable<String> results = new Query7("flights2020.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query7_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query7("flights1990.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query7_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query7("flights2005.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query7_2005.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test8() throws IOException {
        {
            Iterable<String> results = new Query8("flights2020.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query8_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query8("flights1990.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query8_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query8("flights2005.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query8_2005.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }

    @Test
    public void test10() throws IOException {
        {
            Iterable<String> results = new Query10("flights2020.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query10_2020.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query10("flights1990.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query10_1990.txt");
            TestUtilities.checkUnordered(expected, results);
        }
        {
            Iterable<String> results = new Query10("flights2005.csv").execute();
            Set<String> expected = TestUtilities.getExpectedResults1Col("query10_2005.txt");
            TestUtilities.checkUnordered(expected, results);
        }
    }
}
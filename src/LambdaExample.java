import java.util.function.Function;

// Looking at this is optional but potentially helpful
// For context, see Optional Reading section 16.1 of the document
public class LambdaExample {
    public static void main(String[] args) {
        // using a class that implements Function
        Function<String, Integer> f1 = new StringLength();
        System.out.println(f1.apply("abc"));
        // equivalent code written using a lambda expression; no class needed!
        // s is the name of the argument, and s.length() is the return value.
        // Notice that you don't need to write the types of the argument or return value!
        // Java figures out you mean a function from String to Integer.
        Function<String, Integer> f2 = s -> s.length();
        System.out.println(f2.apply("abc"));

        // here's one more example, with a different Function
        Function<Integer, Boolean> c1 = new IsGreaterThan10();
        System.out.println(c1.apply(8));
        System.out.println(c1.apply(11));
        // equivalent code written using a lambda expression; no class needed!
        // x is the name of the argument, and x > 10 is the return value.
        // Notice that you don't need to write the type of the argument or return value!
        // Java figures out you mean a function from Integer to Boolean.
        Function<Integer, Boolean> c2 = x -> x > 10;
        System.out.println(c2.apply(8));
        System.out.println(c2.apply(11));
    }

    private static class StringLength implements Function<String, Integer> {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }

    private static class IsGreaterThan10 implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer integer) {
            return integer > 10;
        }
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Transform {
    // what does the <From,To> mean? For static methods you are required to declare the generic types
    // before you give the return type. You would read this signature as "Given the generic types From
    // and To, transform takes an Iterable<From> and a Function<From, To> and returns an Iterable<To>
    public static <From, To> Iterable<To> transform(Iterable<From> r, Function<From, To> transformer) {

        List<To> result = new LinkedList<>();

        for (From cid : r) {
                result.add((transformer.apply(cid)));
        }
        return result;
    }

}

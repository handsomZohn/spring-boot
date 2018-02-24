package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zohn on 2017/11/15.
 */
public class LambdaList {
    public static void main(String[] args) {
        List feature = Arrays.asList("Lambdas", "default method", "stream api", "date and time Api");
        feature.forEach(a -> System.out.println(a));
        //Java8的方法引用
        feature.forEach(System.out::println);
    }
}

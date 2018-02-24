package lambda;



import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Collections2.filter;

/**
 * Created by zohn on 2017/11/15.
 */
public class UtilFunction {
    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Python", "Scala", "Ruby", "Go", "Php");

        //存在空 过滤空值
        //Stream<String> ls = Stream.of("Java", "Python", null, "Scala", "Ruby", null, "Go", "Php");
        //两块代码因为流的问题不能同时执行
        //List<String> collect = ls.collect(Collectors.toList());
        //collect.forEach(System.out::println);

        //List<String> collect2 = ls.filter(x -> x != null).collect(Collectors.toList());
        //collect2.forEach(System.out::println);

        System.out.println("Languages which starts with J :");

        //filter(languages,(str)-> str.start);

        //filter(languages,(str) -> str.startsWith("J"));

    }


    public static void filter(List names, Predicate condition) {
        for (Object name : names) {
            if (condition.test(name)){
                System.out.println(name + "");
            }
        }
    }

}

package javasenior.java8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @Author hliu
 * @Date 2023/1/23 19:49
 * @Version 1.0
 */
public class LambdaTest2 {
    @Test
    public void test1() {
        helper(400, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("I spend " + aDouble + " !");
            }
        });


        helper(300, aDouble -> System.out.println("He spends " + aDouble + " !"));
    }

    public void helper(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> ret = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(ret);

        List<String> ret1 = filterString(list, s -> s.contains("京"));

        System.out.println(ret1);
    }

    //根據指定規則，過濾集合中的字符串，此規則由predicate決定
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> ret = new ArrayList<>();

        for (String str : list) {
            if (predicate.test(str)) {
                ret.add(str);
            }
        }

        return ret;
    }
}

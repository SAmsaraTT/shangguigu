package javasenior.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

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
}

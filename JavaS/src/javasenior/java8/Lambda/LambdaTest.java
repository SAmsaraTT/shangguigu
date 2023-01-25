package javasenior.java8.Lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 *
 * Lambda表达式的使用举例
 * @Author hliu
 * @Date 2023/1/23 17:58
 * @Version 1.0
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love you!");
            }
        };

        runnable.run();

        Runnable runnable1 = () -> System.out.println("You love me!");
        runnable1.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(comparator.compare(1, 2));

        //Lambda表达式的写法
        Comparator<Integer> comparator1 = (a, b) -> {
            if (a == b) {
                return 0;
            }
            if (a < b) {
                return -1;
            }
            return 1;
        };

        System.out.println(comparator1.compare(3, 1));

        //方法引用
        Comparator<Integer> comparator2 = Integer :: compare;

        System.out.println(comparator2.compare(1, 4));

    }


}

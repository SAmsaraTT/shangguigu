package javasenior.java8;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式的使用
 *
 * 1.举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2.格式：
 *      -> Lambda操作符
 *      -> 左边是形参列表
 *      -> 右边是Lambda体
 * 3.使用 （6种情况）
 *    总结：
 *       ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *       ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 *
 * 4.Lambda表达式的本质：作为接口的实例
 *
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 *
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 * @Author hliu
 * @Date 2023/1/23 18:10
 * @Version 1.0
 */
public class LambdaTest1 {
    //语法格式1：无参，无返回值
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love you!");
            }
        };

        runnable.run();

        Runnable runnable1 = () -> {System.out.println("You love me!");};
        runnable1.run();
    }

    //语法格式2：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Dark Knight Rising!");

        Consumer<String> consumer1 = (String a) -> {System.out.println(a);};

        consumer1.accept("Bruce Wayne");
    }

    //语法格式3：数据类型可以省略，”类型推断“
    @Test
    public void test3() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Dark Knight Rising!");

        Consumer<String> consumer1 = (a) -> {System.out.println(a);};

        consumer1.accept("Bruce Wayne");
    }

    //语法格式4：如果Lambda参数只有一个那么不用写括号
    @Test
    public void test4() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Dark Knight Rising!");

        Consumer<String> consumer1 = a -> {System.out.println(a);};

        consumer1.accept("Bruce Wayne");
    }

    //语法格式5：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(1, 3));

        Comparator<Integer> comparator1 = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return a.compareTo(b);
        };

        System.out.println(comparator1.compare(7, 4));

    }

    //语法格式6：Lambda 体只有一条语句时，return与{}都可以省略
    @Test
    public void test6() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(1, 3));

        Comparator<Integer> comparator1 = (a, b) -> a.compareTo(b);


        System.out.println(comparator1.compare(7, 4));
    }
}

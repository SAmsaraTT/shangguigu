package javasenior.java8.StreamAPI;

import javasenior.java8.MethodReference.Employee;
import javasenior.java8.MethodReference.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * 1. Stream 关注的是数据的运算， 与CPU打交道
 *    集合关注的是数据的存储，于内存打交道
 *
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 *
 *
 * @Author hliu
 * @Date 2023/1/25 17:35
 * @Version 1.0
 */
public class StreamAPITest {
    //创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        Stream<Employee> stream = employees.stream();
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee employee1 = new Employee(1001, "Tom");
        Employee employee2 = new Employee(1002, "Jerry");

        Employee[] arr1 = new Employee[]{employee1, employee2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建Stream方式四：创建无限流
    @Test
    public void test4() {
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(a -> System.out.println(a));


        //生成
        List<Double> list = new ArrayList<>();
        Stream.generate(() -> Math.random()).limit(10).forEach(a -> list.add(a));

        System.out.println(list);
    }

}

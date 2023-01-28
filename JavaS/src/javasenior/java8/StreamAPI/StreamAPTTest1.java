package javasenior.java8.StreamAPI;

import javasenior.java8.MethodReference.Employee;
import javasenior.java8.MethodReference.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 测试Stream的中间操作
 *
 * 常用的方法：ofNullable(T t)
 * orElse(T t)
 *
 * @Author hliu
 * @Date 2023/1/26 18:00
 * @Version 1.0
 */
public class StreamAPTTest1 {

    //1-筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = employees.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(e -> System.out.println(e));
        System.out.println();

        //limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().limit(3).forEach(e -> System.out.println(e));
        System.out.println();

        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(3).forEach(e -> System.out.println(e));
        System.out.println();

        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010, "刘强东", 41, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.stream().distinct().forEach(e -> System.out.println(e));
    }

    //映射
    @Test
    public void test2() {
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
        //练习1：姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(e -> e.getName());
        stringStream.filter(name -> name.length() > 3).forEach(name -> System.out.println(name));

        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(str -> stringToStream(str));
        streamStream.forEach(s -> s.forEach(e -> System.out.println(e)));
        System.out.println();

        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(str -> stringToStream(str));
        characterStream.forEach(str -> System.out.println(str));
    }

    //将字符串中的多个字符构成的集合转换为对应Stream的实例
    public Stream<Character> stringToStream(String str) {
        List<Character> list = new ArrayList<>();

        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    //3-排序
    @Test
    public void test3() {
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(1, 3, 8, 3, 89, 12, 123, 43, 23, -9);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((a, b) -> {
            if (a.getAge() != b.getAge()) {
                return Integer.compare(a.getAge(), b.getAge());
            }
            return Double.compare(b.getSalary(), a.getSalary());
        }).forEach(e -> System.out.println(e));

    }
}

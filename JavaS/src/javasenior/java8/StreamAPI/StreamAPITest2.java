package javasenior.java8.StreamAPI;

import javasenior.java8.MethodReference.Employee;
import javasenior.java8.MethodReference.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试Stream的终止操作
 *
 * @Author hliu
 * @Date 2023/1/27 16:25
 * @Version 1.0
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p)——检查是否匹配所有元素。
        //练习：是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //anyMatch(Predicate p)——检查是否至少匹配一个元素。
        //练习：是否存在员工的工资大于 10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //noneMatch(Predicate p)——检查是否没有匹配的元素。
        //练习：是否存在员工姓“雷”
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b2);

        //findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
        //count——返回流元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        //max(Comparator c)——返回流中的最大值
        //练习：返回最高的工资
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max((a, b) -> Double.compare(a, b));
        System.out.println(max);

        //min(Comparator c)——返回流中的最小值
        //练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        System.out.println(min);

        //forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
        employees.forEach(System.out::println);
    }

    //2-归约
    @Test
    public void test3() {
        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println(reduce);

       //reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
       //练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce((a, b) -> Double.sum(a, b));
        System.out.println(reduce1.get());
    }

    //3-收集
    @Test
    public void test4() {
        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();
        
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}

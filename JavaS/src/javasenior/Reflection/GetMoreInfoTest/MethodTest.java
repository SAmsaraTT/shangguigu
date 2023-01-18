package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodTest {
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        //获取当前运行时类极其所有父类种声明为public的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //获取当前运行时类中声明的方法（不包括父类中的方法）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    /*
    * @Xxxx
    * 权限修饰符， 返回值类型， 方法名（参数类型1 形参名1...) throws XxxException()
    * */
    @Test
    public void test2() {
        System.out.println(Integer.parseInt("021"));
    }
}

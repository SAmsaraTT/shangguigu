package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1.获取方法的注解
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //2.权限修饰符
            System.out.println("权限修饰：" + Modifier.toString(method.getModifiers()));

            //3.返回值类型
            System.out.println("返回值类型：" + method.getReturnType().getName());

            //4.方法名
            System.out.println("方法名：" + method.getName());

            //5.形参列表
            System.out.print(" (");
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " arg_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + " arg_" + i);
                }
            }
            System.out.print(")");
            System.out.println();

            //6.获取异常

            Class<?>[] exceptionTypes = method.getExceptionTypes();

            if (exceptionTypes != null && exceptionTypes.length != 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + " ,");
                }
            }

            System.out.println();
        }
    }
}

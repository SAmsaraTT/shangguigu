package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /*
    * 获取构造器实例
    * */

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        //获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //获取当前运行时类中的所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
    }

    /*
    * 获取运行时类的父类
    * */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
    * 获取运行时类的带泛型的父类
    * */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();

        System.out.println(genericSuperclass);
    }

    /*
    * 获取运行时类的带泛型的父亲的泛型
    * */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    /*
    * 获取运行时类的接口
    * */
    @Test
    public void test5() {
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class clazz : interfaces) {
            System.out.println(clazz);
        }

        //父类的接口
        System.out.println();

        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class clazz : interfaces1) {
            System.out.println(clazz);
        }
    }

    /*
    * 获取运行时类所在的包
    * */
    @Test
    public void test6() {
        Class<Person> personClass = Person.class;

        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    /*
    * 获取运行时类声明的注解
    * */
    @Test
    public void test7() {
        Class<Person> personClass = Person.class;

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

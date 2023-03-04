package javasenior.Reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person p = (Person)tom;
        System.out.println(p.toString());

        Field age = clazz.getDeclaredField("age");

        age.set(p, 10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");

        show.invoke(p);

        // private constructor
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 = (Person)declaredConstructor.newInstance("Jerry");
        System.out.println(p1);

        // private field
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "GG");
        System.out.println(p1);

        // private method
        Method showCitizenship = clazz.getDeclaredMethod("showCitizenship", String.class);
        showCitizenship.setAccessible(true);
        String c = (String)showCitizenship.invoke(p, "CN");
        System.out.println(c);

        //建议直接使用封装性
        //反射使用其动态性

    }

    //获取Class的实例方式
    //加载到内存的运行时类，会缓存一定时间
    @Test
    public void test2() throws ClassNotFoundException {
        //way 1
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        //way 2
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //way 3
        Class aClass = Class.forName("javasenior.Reflection.Person");
        System.out.println(aClass);

        //way 4
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass1 = classLoader.loadClass("javasenior.Reflection.Person");
        System.out.println(aClass1 == aClass);


    }
}

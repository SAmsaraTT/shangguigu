package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* 调用运行时类中指定的结构：属性，方法，构造器
* */
public class ReflectionTest1 {
    @Test
    public void tesField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();

        //获取指定属性: 要求运行时类中的属性声明为public
        //开发中不常用！
        Field id = personClass.getField("id");

        /*
        * 设置当前属性的值
        * set():参数1：指明哪个对象的属性 参数2：将此属性值设置为多少
        * */

        id.set(person, 1001);

        /*
        * 获取当前属性的值
        * get() 参数1 ：获取哪个对象的当前属性值
        * */

        int pId = (int) id.get(person);

        System.out.println(pId);
    }

    @Test
    public void testField1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();

        //1. getDeclaredField(String fieldName):获取指定变量名的的属性
        Field name = personClass.getDeclaredField("name");

        //2. 保证当前属性是可访问的
        name.setAccessible(true);

        //3. 获取指定当前属性的值
        name.set(person, "Tom");

        System.out.println(name.get(person));

    }

    /*
    * 如何操作运行时类中的指定的方法 -- 需要掌握
    * */
    @Test
    public void testMethod() throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();

        /*
        * 1.获取指定的某个方法
        * getDeclaredMethod(): 参数1：方法的名称 参数2：方法的形参列表
        * */
        Method show = personClass.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        /*
        * 3.invoke(): 参数1：方法的调用者 参数2：实参
        * invoke()方法的返回这即为对应类方法的返回值
        * */
        Object cn = show.invoke(person, "CN");

        System.out.println((String)cn);

        //调用静态方法

        Method showInfo = personClass.getDeclaredMethod("showInfo");
        showInfo.setAccessible(true);
        //没有返回值则返回null
        Object invoke = showInfo.invoke(Person.class);
        System.out.println(invoke);
    }

    /*
     * 如何操作运行时类中的指定的构造器
     * */
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        //1.获取指定的构造器 参数：构造器的参数列表
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person tom = declaredConstructor.newInstance("Tom");

        System.out.println(tom);

    }

}

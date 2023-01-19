package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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
}

package javasenior.Reflection.GetMoreInfoTest;

import javasenior.Reflection.GetMoreInfo.Creature;
import javasenior.Reflection.GetMoreInfo.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1() {
        Class clazz = Person.class;
        //获取public属性，包括父类
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        //获取当前类的所有属性不包括父类
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredFiled : declaredFields) {
            System.out.println(declaredFiled);
        }
    }

    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredFiled : declaredFields) {
            //1.权限修饰符
            int modifiers = declaredFiled.getModifiers();
            System.out.println("权限： " + Modifier.toString(modifiers));

            //2.数据类型
            Class<?> type = declaredFiled.getType();
            System.out.println("数据类型：" + type.getName());

            //3.变量名
            String name = declaredFiled.getName();
            System.out.println("变量名：" + name);
        }
    }
}

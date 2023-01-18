package javasenior.Reflection;

import javasenior.IOTest.RandomAccess_T.RandomAccessTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.EnumSelector;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
        * 1.空参构造器
        * 2.空参构造器的权限得够
        */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    @Test
    public void  test2() {

        for (int i = 0; i < 100; i++) {
            int flag = new Random().nextInt(3);
            String path = "";

            switch (flag) {
                case 0:
                    path = "java.util.Date";
                    break;
                case 1:
                    path = "java.lang.Object";
                    break;
                case 2:
                    path = "javasenior.Reflection.Person";
            }

            try {
                Object object = getInstance(path);
                System.out.println(object);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Object getInstance(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(path);
        return clazz.newInstance();
    }
}

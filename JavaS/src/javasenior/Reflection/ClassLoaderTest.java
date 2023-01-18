package javasenior.Reflection;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//cannot get the bootstrap classLoader

        System.out.println(String.class.getClassLoader());

    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //此时文件在当前的module下 way1
        FileInputStream fileInputStream = new FileInputStream("jdbc1.properties");


        //way 2
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(fileInputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }
}

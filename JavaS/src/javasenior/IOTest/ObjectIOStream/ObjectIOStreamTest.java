package javasenior.IOTest.ObjectIOStream;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectIOStreamTest {

    @Test
    public void test1() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("还是会想你！"));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("hliu", 22, new Account(51.0)));
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test2() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = objectInputStream.readObject();
            String str = (String)obj;
            Person p = (Person)objectInputStream.readObject();
            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}

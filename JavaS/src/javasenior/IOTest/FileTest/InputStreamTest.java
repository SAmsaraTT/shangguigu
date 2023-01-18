package javasenior.IOTest.FileTest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class InputStreamTest {

    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        char[] cbuf = new char[20];
        int len;

        while ((len = inputStreamReader.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);

            System.out.println(str);
        }

        inputStreamReader.close();
    }


    @Test
    public void test2() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");


        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");

        char[] cbuf = new char[20];

        int len;

        while ((len = inputStreamReader.read(cbuf)) != -1) {
            outputStreamWriter.write(cbuf, 0, len);
        }
        inputStreamReader.close();
        outputStreamWriter.close();



    }
}

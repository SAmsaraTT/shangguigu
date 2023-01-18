package com.shangguigu.exceptiontest;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionTest1 {
    @Test
    public void test1() {
        Set<String> list = new HashSet<>();
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            StringBuilder sb = new StringBuilder();
            while(data != -1){
                if ((char)data == ',') {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                    data = fis.read();
                    continue;
                }
                System.out.print((char)data);
                sb.append((char)data);
                data = fis.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(list);

        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello2.txt");
            System.out.println(file.getAbsolutePath());
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, false);

            //3.写出的操作
            for (String email : list) {
                fw.write(email + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        File file = new File("hello2.txt");
        file.delete();

    }
}

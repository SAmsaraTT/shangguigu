package com.shangguigu.LeetCodetest;

import org.junit.jupiter.api.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class testLeetcode {
    @Test
    public void testSet() {
        String[] strings = new String[3];
        strings[0] = "A1";
        strings[1] = "A3";
        strings[2] = "A2";
        Arrays.sort(strings, (a, b) -> {
            return b.compareTo(a);
        });
        for (String s : strings) {
            System.out.println(s);
        }

        List<Integer> list = new ArrayList<>();
        String s = "";
        System.out.println(Integer.toString(4, 2));

    }

    public testLeetcode() {
    }
}

class Solution {
    @Test
    public void findLUSlength() {
        String[] strs = {"aba","aba","eae"};
        TreeSet<String> tree = new TreeSet<String>(new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return b.length() - a.length();
                }

                return a.compareTo(b);
            }
        });

        for (String str : strs) {
            tree.add(str);
            //System.out.print(str);
        }
        for (String s : tree) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //此时文件在当前的module下 way1
        FileInputStream fileInputStream = new FileInputStream("src\\jdbc2.properties");


        //way 2
        ClassLoader classLoader = Solution.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc3.properties");
        properties.load(fileInputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }


}

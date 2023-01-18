package com.shangguigu.test;


import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;

import java.util.Scanner;


public class test1 {
    public static void main(String[] args) throws MyException {
        CusTest g = new sub(3, 2);


        sub s = new sub(2, 6);

        s.sing();
        g.sing();


        sub c = (sub)g;
        System.out.println(c.n);

        if (s.age > 3) {
            throw new RuntimeException("寄了");
        } else {
            System.out.println("meiji");
        }

        variablesTest v = new variablesTest() {


            @Override
            public void eat() {

            }

            @Override
            public int getN() {
                return 0;
            }

            @Override
            public void setN(int n) {
               this.age = n;
            }
        };

        v.add(-1);




    }


    public void getTest() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int next = sc.nextInt();

            variablesTest v1 = new sub();

            v1.age = next;

            System.out.println(v1.age);


        }


    }

}



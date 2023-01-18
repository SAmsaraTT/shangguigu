package com.shangguigu.scannertest;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.TreeSet;


public class ScannerTest {
    public static void main(String[] args) {
        ScannerTest scannerTest = new ScannerTest();
        scannerTest.scTest();
    }
    public void scTest(){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(str);
        }



    }
}

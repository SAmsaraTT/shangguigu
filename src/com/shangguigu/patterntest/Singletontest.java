package com.shangguigu.patterntest;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Singletontest {
    public static void main(String[] args) {
        Order test1 = Order.getInstance();
        Order test2 = Order.getInstance();
        test2.setAge(18);
        System.out.println(test1.getAge());
    }
}

class Order{

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Order() {

    };

    private static Order instance = new Order();

    {
        System.out.println("ggggggggg");
    }
    public static Order getInstance() {

        return instance;
    }


}

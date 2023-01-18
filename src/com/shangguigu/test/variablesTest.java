package com.shangguigu.test;

import java.util.Objects;

public abstract class variablesTest {
    public int age;
    public String name;

    static int cnt = 1001;

    public variablesTest(int age) {

        this.age = age;
    }

    public variablesTest() {
        System.out.println("wocao!");
    }

    public void add(int num) throws MyException {
        if (num < 0) {
            throw new MyException("negative");
        } else {

            this.age += num;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof variablesTest)) return false;
        variablesTest that = (variablesTest) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "variablesTest{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    public void test(int... g) {

        System.out.println(g[1]);

    }
    public abstract void eat();

    public abstract int getN();

    public abstract void setN(int n);


}


class sub extends variablesTest implements CusTest,CustTest2 {
    public int n;
    public sub() {
        super();
    }

    public sub(int age, int n) {
        super(age);
        this.n = n;
    }

    @Override
    public void eat() {
        System.out.println("chifan");
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public int eat(int n) {
        return 123;
    }

    @Override
    public void run() {

    }

    @Override
    public void sing() {
        System.out.println("sing a song" + this.n);
    }
}

interface CusTest{

    int eat(int n);
    void sing();
}

interface CustTest2 {

    int eat(int n);

    void run();
}

abstract class GG {
    abstract int eat(int n);
}

class Test2 extends GG implements  CusTest, CustTest2 {

    @Override
    public int eat(int n) {
        return 0;
    }

    @Override
    public void run() {
        
    }

    @Override
    public void sing() {

    }
}

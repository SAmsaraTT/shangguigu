package javasenior.thread;



public class ThreadTest {
    public static void main(String[] args) {
        Mythread mythread1 = new Mythread();
        Mythread mythread2 = new Mythread();
        mythread1.start();
        mythread2.start();

    }
}

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

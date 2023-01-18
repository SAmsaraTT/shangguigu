package javasenior.thread;

class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread1 = new Thread(mThread);
        thread1.start();
    }
}

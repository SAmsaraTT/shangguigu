package javasenior.thread;
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();

        h1.setName("线程1");
        Thread.currentThread().setName("主线程");
        h1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}

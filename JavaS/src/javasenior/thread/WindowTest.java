package javasenior.thread;

public class WindowTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");



        w1.start();
        w2.start();
        w3.start();

    }
}

class Window implements Runnable{
    private int ticket = 1000;
    Object o = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (o) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}



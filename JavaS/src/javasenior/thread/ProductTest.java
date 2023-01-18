package javasenior.thread;
/*
* 多线程：生产者消费者问题
*
* */
class Clerk {
    private int cnt = 0;
    public synchronized void produceProduct() {
        if (cnt < 20) {
            cnt++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + cnt + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consumeProduct() {
        if (cnt > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + cnt + "个产品");
            cnt--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品。。。。。");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品。。。。。");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者2");

        p1.start();
        c1.start();


    }
}

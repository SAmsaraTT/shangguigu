package javasenior.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor s1 = (ThreadPoolExecutor) executorService;

        s1.execute(new NumThread());
        //executorService.submit();
        s1.shutdown();
    }
}


class  NumThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }
    }
}

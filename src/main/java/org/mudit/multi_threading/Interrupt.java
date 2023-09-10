package org.mudit.multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);
        ExecutorService ex = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            ex.submit(new MyRunnable3(counter));
        }
        // Thread.sleep(1000);
        System.out.println(counter);
        ex.shutdown();
    }
}

class MyRunnable3 implements Runnable {
    public AtomicLong counter;

    public MyRunnable3(AtomicLong counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.incrementAndGet();
    }

}
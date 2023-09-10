package org.mudit.multi_threading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch startSignal = new CountDownLatch(4);

        new Thread(new Worker(startSignal)).start();

        for (int i = 4; i > 0; i--) {
            System.out.println("Making worker thread to wait" + " count down.. " + i);
            startSignal.countDown();
            Thread.sleep(5000);
        }

    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;

    Worker(CountDownLatch startSignal) {
        this.startSignal = startSignal;

    }

    @Override
    public void run() {
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();

    }

    void doWork() {
        System.out.println("Worker is doing his work" + Thread.currentThread().getName());

    }
}
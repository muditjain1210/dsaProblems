package org.mudit.multi_threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class BlockingQueueExample {

    public static void main(String[] args) {
        CountDownLatch f = new CountDownLatch(2);
        CyclicBarrier c = new CyclicBarrier(6);
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(100);

        Publisher<Integer> pub = new Publisher<>(bq);
        Subsriber<Integer> sub = new Subsriber<>(bq);
        Thread th1 = new Thread(pub);
        Thread th2 = new Thread(sub);
        th1.start();
        th2.start();
    }
}

class Publisher<T> implements Runnable {
    private final BlockingQueue<T> q;

    public Publisher(BlockingQueue<T> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                T obj = (T) new Object();
                System.out.println("Adding item to Queue" + obj);
                q.put(obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Subsriber<T> implements Runnable {
    private final BlockingQueue<T> q;

    public Subsriber(BlockingQueue<T> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                T obj = q.take();
                System.out.println("Removing item from Queue" + obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
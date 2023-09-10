package org.mudit.multi_threading;

public class ThreadPractice {

    public static void main(String args[]) throws InterruptedException {
        // lambda expression using Runnable interface..
        Runnable r = () -> System.out.println("running in new thread" + Thread.currentThread().getName());

        // Thread th2 = new Thread(r);
        // th2.run(); // THIS will not be a new Thread !!.. will be MAIN thread..

        Counter c = new Counter();
        MyRunnable r2 = new MyRunnable(c);
        Thread th1 = new Thread(r2);

        Thread th2 = new Thread(r2);
        th1.start();
        th2.start();
    }

}

class MyRunnable implements Runnable {

    Counter count = null;

    public MyRunnable(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        int i = 1;
        while (i < 10) {
            count.add(i);

            i++;
        }

    }
}

class Counter {

    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
        System.out.println(Thread.currentThread().getName() + " " + value + " " + count);
    }
}
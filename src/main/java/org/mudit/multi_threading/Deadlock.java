package org.mudit.multi_threading;

public class Deadlock {

    public static void main(String[] args) {


        MyRunnable2 run = new MyRunnable2();
        run.a = Integer.valueOf(10);
        run.b = "abc";
        Thread th1 = new Thread(run);
        Thread th2 = new Thread(run);
        th1.start();
        th2.start();

    }

}

class MyRunnable2 implements Runnable {
    public Integer a;
    public String b;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method();
        } else {
            method2();
        }
    }

    public void method() {
        synchronized (a) {
            System.out.println(Thread.currentThread().getName() + " GOT THE LOCK of A");

            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + " GOT THE LOCK of B");
            }
        }
    }

    public void method2() {
        synchronized (b) {
            System.out.println(Thread.currentThread().getName() + " GOT THE LOCK of B");

            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + " GOT THE LOCK of A");
            }
        }
    }
}

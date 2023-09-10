package org.mudit.multi_threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueExample {
    public static void main(String[] args) {

        BlockingQueue<Employee> dq = new DelayQueue<>();

        PublisherDelayed pub = new PublisherDelayed(dq);
        SubsriberDelayed sub = new SubsriberDelayed(dq);
        Thread th1 = new Thread(pub);
        Thread th2 = new Thread(sub);
        th1.start();
        th2.start();
    }
}

class Employee implements Delayed {
    private final long maxQueueLivingTime = 20000;
    private final String name;
    private final long creationTime;
    public Employee(String name) {

        this.name = name;
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Employee [maxQueueLivingTime=" + maxQueueLivingTime + ", name=" + name + ", creationTime=" + creationTime + "]";
    }

    @Override
    public int compareTo(Delayed o) {
        Employee e = (Employee) o;
        return (int) (this.creationTime - e.creationTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long timeSinceCreated = System.currentTimeMillis() - creationTime;
        return maxQueueLivingTime - timeSinceCreated;
    }

}

class PublisherDelayed implements Runnable {
    private final BlockingQueue<Employee> q;

    public PublisherDelayed(BlockingQueue<Employee> q) {
        this.q = q;
    }

    @Override
    public void run() {
        Employee e1 = new Employee("mudit");
        System.out.println("Adding emp object to queue" + e1);
        q.offer(e1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Employee e2 = new Employee("jain");
        System.out.println("Adding emp object to queue" + e2);
        q.offer(e2);

    }

}

class SubsriberDelayed implements Runnable {
    private final BlockingQueue<Employee> q;

    public SubsriberDelayed(BlockingQueue<Employee> q) {
        this.q = q;
    }

    @Override
    public void run() {

        try {
            Employee e1 = q.take();
            System.out.println("removing from Q" + e1);
            Employee e2 = q.take();
            System.out.println("removing from Q" + e2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
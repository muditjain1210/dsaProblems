package org.mudit.multi_threading;

import java.util.LinkedList;
import java.util.Queue;

//Publisher Subscriber using a  shared Queue 
public class PubSubWithoutWaitNotify {

    // Publisher Subscriber using a shared Queue

    public static void main(String args[]) {
        SharedQueue2 sq = new SharedQueue2(new LinkedList<>(), 25);
        PubSubThread2 th1 = new PubSubThread2(sq, true);
        PubSubThread2 th2 = new PubSubThread2(sq, false);
        th1.start();
        th2.start();

    }
}

class PubSubThread2 extends Thread {

    private SharedQueue2 q;
    private boolean isPub;

    public PubSubThread2(SharedQueue2 q, boolean isPub) {
        this.q = q;
        this.isPub = isPub;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 200) {
            if (isPub) {
                q.add(i++);
            } else {
                q.remove();
            }
        }

    }

}

class SharedQueue2 {
    private Queue<Integer> queue;
    private int MAX_SIZE;

    public SharedQueue2(Queue<Integer> queue, int max_size) {
        this.queue = queue;
        this.MAX_SIZE = max_size;
    }

    void add(int i) {

        while (queue.size() >= MAX_SIZE) {
            try {
                System.out.println("QUEUE IS FULL!!");
                Thread.sleep(1);
            } catch (InterruptedException ex) {

                ex.printStackTrace();
            }
        }
        System.out.println("Producer adding item to" + queue + i);
        queue.add(i);
    }

    void remove() {

        while (queue.isEmpty()) {
            try {
                System.out.println("QUEUE IS EMPTY!!");
                Thread.sleep(1);
                // System.out.println("HAHA");
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        System.out.println("Consumer removing item from" + queue + queue.peek());
        queue.remove();

    }
}

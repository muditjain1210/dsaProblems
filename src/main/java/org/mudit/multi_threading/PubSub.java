package org.mudit.multi_threading;

import java.util.LinkedList;
import java.util.Queue;

//Publisher Subscriber using a  shared Queue 
public class PubSub {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Thread pub = new Thread(new Publisher2(queue));
        Thread sub = new Thread(new Subscriber2(queue));
        pub.start();
        sub.start();

    }
}

class Publisher2 implements Runnable {
    private final Queue<Integer> queue;

    public Publisher2(Queue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (queue) {
                /**
                 * Condition checks must be placed in while loops. When an action is resumed, the waiting task doesn't know whether the
                 * condition it is waiting for is actually true; it only knows that it has been woken up. So, in order to maintain safety
                 * properties, it must check again.
                 *
                 * (Page 158).
                 */
                while (queue.size() >= 10) {
                    try {
                        System.out.println("QUEUE IS FULL!!");
                        queue.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Producer adding item to" + queue + i);
                queue.add(i++);
                // we have to do queue.notify() because we have entered synchronized block by acquiring lock on
                // queue object not on THIS(Publisher2) object..if we do notify() then IllegalMonitorStateException will be thrown
                // because we did not entered synchronized block using Publisher2 lock and asking for notified for Publisher
                // object
                queue.notify();

            }
        }
    }
}

class Subscriber2 implements Runnable {
    private final Queue<Integer> queue;

    public Subscriber2(Queue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("QUEUE IS EMPTY!!");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer removing item from" + queue + queue.peek());
                queue.remove();
                queue.notify();
            }
        }
    }
}

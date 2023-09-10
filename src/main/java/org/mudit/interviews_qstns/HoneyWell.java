package org.mudit.interviews_qstns;

public class HoneyWell {

    public static void main(String[] args) throws InterruptedException {
        // System.out.println(FiveInstances.getInstance());
        // System.out.println(FiveInstances.getInstance());
        // System.out.println(FiveInstances.getInstance());
        // System.out.println(FiveInstances.getInstance());
        // System.out.println(FiveInstances.getInstance());

        // System.out.println(FiveInstances.count);

        // System.out.println(FiveInstances.getInstance());
        // System.out.println(FiveInstances.getInstance());
        // FiveInstances.releaseInstance();

        // System.out.println(FiveInstances.count);

        // ===================================================

        ThreadedLL obj = new ThreadedLL();
        Thread th1 = new LLThreaded(true, obj); // publisher/adder
        Thread th2 = new LLThreaded(false, obj); // remover

        th1.start();
        th2.start();

    }

}

class LLThreaded extends Thread {
    boolean isProducer;
    ThreadedLL list;

    LLThreaded(boolean isProducer, ThreadedLL list) {
        this.isProducer = isProducer;
        this.list = list;

    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000) {
            if (isProducer) {
                LLNode node = new LLNode(null, i++);
                list.add(node);

            } else {
                list.remove();
            }
        }
    }
}

class ThreadedLL {
    private LLNode head;

    synchronized LLNode add(LLNode node) {
        if (head == null) {
            head = node;
            System.out.println("adding item to LIST" + " " + node.data);
        } else {
            LLNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.println("adding item" + " " + node.data);
            temp.next = node;
        }
        notify();
        return head;
    }

    synchronized LLNode remove() {
        if (head == null) {
            try {
                System.out.println("LL IS EMPTY!!");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("removing head" + " " + head.data);
        LLNode newHead = head.next;
        head.next = null;
        head = newHead;
        return head;
    }
}

class LLNode {
    LLNode next;
    int data;

    LLNode(LLNode next, int data) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "-->";
    }
}

class FiveInstances {
    public static int count = 0;

    private FiveInstances() {

    }

    public static synchronized FiveInstances getInstance() throws InterruptedException {
        if (count < 5) {
            count++;
            return new FiveInstances();
        } else {
            while (count > 5) {
                Thread.sleep(100000);
            }
            count++;
            return new FiveInstances();
        }
    }

    public static synchronized void releaseInstance() {
        count--;
    }
}
package org.mudit.multi_threading;
public class VolatileCheck extends Thread {
    boolean isProducer;
    volatile static int count = 0;

    VolatileCheck(boolean isProducer) {
        this.isProducer = isProducer;

    }

    @Override
    public void run() {
        if (isProducer) {
            while (count < 100) {
                // System.out.println("Incrementing " + count);
                count++;
                System.out.println("Incrementing " + count);

            }

        } else {
            while (count < 100) {
                System.out.println("Reading " + count);
            }
        }
    }
}

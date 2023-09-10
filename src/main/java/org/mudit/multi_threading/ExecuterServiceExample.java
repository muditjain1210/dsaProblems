package org.mudit.multi_threading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuterServiceExample {

    public static void main(String[] args) {
        ScheduledExecutorService ser = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 5; i++) {
            ser.scheduleAtFixedRate(new Task(), 10, 10, TimeUnit.SECONDS);
        }
    }

}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Running Task by thread" + Thread.currentThread().getName());

    }

}
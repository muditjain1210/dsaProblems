package org.mudit.multi_threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService ser = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Future<Integer> fut = ser.submit(new Task2());
            futList.add(fut);
        }
        System.out.println("Running MAIN ");
        for (Future<Integer> f : futList) {
            System.out.println(f.get().intValue());
        }
    }

}

class Task2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return new Random().nextInt();
    }
}
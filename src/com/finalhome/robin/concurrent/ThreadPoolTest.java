package com.finalhome.robin.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            WorkerThread worker = new WorkerThread(String.valueOf(i),i,i+10);
            executorService.submit(worker);
        }
        executorService.shutdown();
    }
}

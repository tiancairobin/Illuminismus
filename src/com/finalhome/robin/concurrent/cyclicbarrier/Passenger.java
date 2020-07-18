package com.finalhome.robin.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Passenger implements Callable<Boolean> {
    private String name;
    private boolean isOnboard = false;
    private CyclicBarrier cyclicBarrier;

    public Passenger(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    public boolean isOnboard() {
        return isOnboard;
    }

    public void setOnboard(boolean onboard) {
        isOnboard = onboard;
    }

    public String getName() {
        return name;
    }

    private void onboard() throws BrokenBarrierException, InterruptedException {
        System.out.println(name + "：上车中");
        System.out.println("On Vehicle: " + cyclicBarrier.getNumberWaiting());
        cyclicBarrier.await();
        System.out.println(name + ": 已出发");
        isOnboard = true;
    }

    @Override
    public Boolean call() {
        try {
            TimeUnit.SECONDS.sleep(1 + new Random().nextInt(5));
            onboard();
            return isOnboard;
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
            System.out.println(name + ": 无法上车");
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(name + ": 无法上车");
            return false;
        }
    }
}

package com.finalhome.robin.concurrent.cyclicbarrier;

public class Vehicle implements Runnable{
    @Override
    public void run() {
        System.out.println("发车！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("车辆返回");
    }
}

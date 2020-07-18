package com.finalhome.robin.concurrent.cyclicbarrier;

import java.util.concurrent.*;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier taxi = new CyclicBarrier(4, new Vehicle());
        //  汉钟离、张果老、韩湘子、铁拐李、吕洞宾、何仙姑、蓝采和及曹国舅
        Passenger hanZhongLi = new Passenger("汉钟离", taxi);
        Passenger zhangGuoLao = new Passenger("张果老", taxi);
        Passenger hanXiangZi = new Passenger("韩湘子", taxi);
        Passenger tieGuaiLi = new Passenger("铁拐李", taxi);
        Passenger lvDongBin = new Passenger("吕洞宾", taxi);
        Passenger heXianGu = new Passenger("何仙姑", taxi);
        Passenger lanCaiHe = new Passenger("蓝采和", taxi);
        Passenger caoGuoJiu = new Passenger("曹国舅", taxi);

        ExecutorService service = Executors.newCachedThreadPool();
        FutureTask<Boolean> task1 = new FutureTask<>(hanZhongLi);
        FutureTask<Boolean> task2 = new FutureTask<>(zhangGuoLao);
        FutureTask<Boolean> task3 = new FutureTask<>(hanXiangZi);
        FutureTask<Boolean> task4 = new FutureTask<>(tieGuaiLi);
        FutureTask<Boolean> task5 = new FutureTask<>(lvDongBin);
        FutureTask<Boolean> task6 = new FutureTask<>(heXianGu);
        FutureTask<Boolean> task7 = new FutureTask<>(lanCaiHe);
        FutureTask<Boolean> task8 = new FutureTask<>(caoGuoJiu);
        service.submit(task1);
        service.submit(task2);
        service.submit(task3);
        service.submit(task4);
        service.submit(task5);
        service.submit(task6);
        service.submit(task7);
        service.submit(task8);
        service.shutdown();
        try {
            System.out.println("1: " + task1.get());
            System.out.println("2: " + task2.get());
            System.out.println("3: " + task3.get());
            System.out.println("4: " + task4.get());
            System.out.println("5: " + task5.get());
            System.out.println("6: " + task6.get());
            System.out.println("7: " + task7.get());
            System.out.println("8: " + task8.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}

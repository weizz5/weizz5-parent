package com.weizz5.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有一家生产奶酪的厂家，每天需要生产100000份奶酪卖给超市，通过一辆送货车发货，送货车辆每次送100份。
 * 厂家有一个容量为1000份的冷库，用于奶酪保鲜，生产的奶酪需要先存放在冷库，运输车辆从冷库取货。
 * 厂家有三条生产线，分别是牛奶供应生产线，发酵剂制作生产线，奶酪生产线。生产每份奶酪需要2份牛奶和1份发酵剂。
 * 请设计生产系统。
 *
 * @author weizz5
 * @date 2020/05/13
 */
public class CheeseProducerDemo {

    //    private LinkedBlockingQueue<Cheese> coldStorage = new LinkedBlockingQueue<>(100);
    private List<Cheese> coldStorage = new ArrayList<>(100);


    private AtomicInteger cheeseNum = new AtomicInteger();


    private volatile boolean flag = true;

    private int maxValue = 500;

    public void producer() {
        while (flag) {
            Cheese cheese = new Cheese("cheesename - " + cheeseNum.incrementAndGet());
            coldStorage.add(cheese);
            System.out.println("produce --- " + cheese);

            if (cheeseNum.get() == maxValue) {
//                flag = false;
                break;
            }
        }
    }

    public void consumer() {
        while (flag) {
            Cheese cheese = null;
            try {
                Thread.sleep(1);

                cheese = coldStorage.remove(0);
                System.out.println("consumer --- " + cheese);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        CheeseProducerDemo producerDemo = new CheeseProducerDemo();

        new Thread(() -> {
            producerDemo.producer();
        }, " producerThread-- ").start();

        new Thread(() -> {
            producerDemo.consumer();
        }, " consumerThread-- --  ").start();

    }

}

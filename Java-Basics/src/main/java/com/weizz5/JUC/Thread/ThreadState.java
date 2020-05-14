package com.weizz5.JUC.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/15
 */
public class ThreadState {

    private static  Object object = new Object();
    private static AtomicInteger count = new AtomicInteger();

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("run start: "+this.getState());

            synchronized (object){
                for (; count.get() < 10; count.incrementAndGet()) {

                    try {
                        Thread.sleep(1000);
                        if(count.get()%2 == 0){
                            object.wait();
                        }else {
                            Thread.yield();
                            Thread.sleep(300);

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        System.out.println("start ... "+myThread.getState());

        myThread.start();
        System.out.println("start over: "+myThread.getState());
        while (true){
            synchronized (object){
                try {
//                    if(count.get()%2 == 1){
//                        Thread.sleep(500);
//                    } else {
//                        object.notifyAll();
//                        Thread.sleep(500);
//                    }
                    object.notifyAll();
                    object.wait(50);
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("while: "+myThread.getState()+",count:"+count.get());
            }

        }
    }
}

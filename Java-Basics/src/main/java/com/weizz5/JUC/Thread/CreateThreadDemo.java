package com.weizz5.JUC.Thread;

import java.util.concurrent.Executors;

/**
 * 创建线程的方式
 *
 * @author weizz5
 * @date 2020/05/14
 */
public class CreateThreadDemo {

    static class ExtendsThread extends Thread{

        @Override
        public void run() {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Extends Thread !");

        }
    }

    static class ImplementsRunnable implements Runnable{

        @Override
        public void run() {
            long time = System.currentTimeMillis();
            Thread.yield();
            System.out.println("times:"+(System.currentTimeMillis()-time)+" ms");
            System.out.println("Implements Runnable!");

        }
    }

    public static void main(String[] args) {

        new ExtendsThread().start();

        new Thread(new ImplementsRunnable()).start();

        new Thread(() -> System.out.println("lamda test!")).start();

        Executors.newCachedThreadPool().submit(() -> System.out.println("executor thread test !"));

    }

}

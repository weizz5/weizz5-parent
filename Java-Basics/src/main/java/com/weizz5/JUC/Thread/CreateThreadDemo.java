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
            System.out.println("Extends Thread !");
        }
    }

    static class ImplementsRunnable implements Runnable{

        @Override
        public void run() {
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

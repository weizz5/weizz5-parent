package com.weizz5.Thread;

/**
 * Java 守护进程
 *
 * @author weizz5
 * @date 2020/04/27
 */
public class DaemonThread {

    public static void main(String[] args) {

        //设置守护线程
        Thread thread = new Thread();
        thread.setDaemon(true);
        thread.start();
        System.out.println(thread.isDaemon());
//        thread.isDaemon();

    }
}

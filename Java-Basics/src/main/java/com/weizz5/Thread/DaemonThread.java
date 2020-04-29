package com.weizz5.Thread;

/**
 * Java 守护进程
 *
 * @author weizz5
 * @date 2020/04/27
 */
public class DaemonThread {

    public static void main(String[] args) {

        Thread thread = new Thread();
        //设置守护线程
        thread.setDaemon(true);
        thread.start();
        // 验证当前线程是否为守护线程，返回 true 则为守护线程
        System.out.println(thread.isDaemon());
//        thread.isDaemon();


    }
}

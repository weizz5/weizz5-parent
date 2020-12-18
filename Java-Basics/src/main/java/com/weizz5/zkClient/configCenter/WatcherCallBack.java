package com.weizz5.zkClient.configCenter;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/09
 */
public class WatcherCallBack implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {


    private ZooKeeper zooKeeper;


    private MyConf myConf;


    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public MyConf getMyConf() {
        return myConf;
    }

    public void setMyConf(MyConf myConf) {
        this.myConf = myConf;
    }

    public WatcherCallBack(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public void aWait() {
        zooKeeper.exists("/weizz5", this, this, " WatcherCallBack - exists - ctx ");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * DataCallback
     *
     * @param rc
     * @param path
     * @param ctx
     * @param data
     * @param stat
     */
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {

        if (null != data) {
            String dataStr = new String(data);

            myConf.setConf(dataStr);
            countDownLatch.countDown();
        }
    }


    /**
     * StatCallback
     *
     * @param rc
     * @param path
     * @param ctx
     * @param stat
     */
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if (null != stat) {
            zooKeeper.getData("/weizz5", this, this, "WatcherCallBack ctx");
        }
    }

    /**
     * Watcher
     *
     * @param event
     */
    public void process(WatchedEvent event) {

        switch (event.getType()) {
            case None:
                System.out.println("WatcherCallBack  None!!!");
                break;
            case NodeCreated:
                System.out.println("WatcherCallBack  NodeCreated!!!");
                break;
            case NodeDeleted:
                System.out.println("WatcherCallBack  NodeDeleted!!!");
                break;
            case NodeDataChanged:
                System.out.println("WatcherCallBack  NodeDataChanged!!!");
                zooKeeper.getData("/weizz5", this, this, "WatcherCallBack ctx");
                break;
            case NodeChildrenChanged:
                System.out.println("WatcherCallBack  NodeChildrenChanged!!!");
                break;
        }

    }
}

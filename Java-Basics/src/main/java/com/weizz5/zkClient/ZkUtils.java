package com.weizz5.zkClient;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.WatcherEvent;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/08
 */
public class ZkUtils {


    public static void main(String[] args) throws Exception {

        //
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        final ZooKeeper zooKeeper = new ZooKeeper("10.1.130.101:2181,10.1.130.102:2181,10.1.130.103:2181,", 5000,
                new Watcher() {

                    // 回调方法
                    public void process(WatchedEvent watchedEvent) {
                        Event.KeeperState state = watchedEvent.getState();
                        Event.EventType type = watchedEvent.getType();

                        String path = watchedEvent.getPath();
                        System.out.println("new zk watch: "+watchedEvent.toString());

                        switch (state) {
                            case Unknown:
                                break;
                            case Disconnected:
                                break;
                            case NoSyncConnected:
                                break;
                            case SyncConnected:
                                System.out.println("SyncConnected");
                                countDownLatch.countDown();
                                break;
                            case AuthFailed:
                                break;
                            case ConnectedReadOnly:
                                break;
                            case SaslAuthenticated:
                                break;
                            case Expired:
                                break;
                        }


                        switch (type) {
                            case None:
                                break;
                            case NodeCreated:
                                break;
                            case NodeDeleted:
                                break;
                            case NodeDataChanged:
                                break;
                            case NodeChildrenChanged:
                                break;
                        }

                    }
                });


        countDownLatch.await();
        ZooKeeper.States states = zooKeeper.getState();

        switch (states) {
            case CONNECTING:
                System.out.println("CONNECTING...");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("CONNECTED......");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
        }

        String pathName = zooKeeper.create("/weizz5", "weizz5testzk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.out.println("pathName:"+pathName);

        final Stat stat = new Stat();
        byte[] node = zooKeeper.getData("/weizz5", new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("getData watch:"+event.toString());

                try {
//                    zooKeeper.getData("/weizz5",true,stat);
                    zooKeeper.getData("/weizz5",this,stat);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, stat);


        System.out.println("zooKeeper.getData,node:"+new String(node));
        Stat setdataStat1 = zooKeeper.setData("/weizz5", "weizz5 test zk setdata".getBytes(), 0);

        System.out.println("setdataStat1:"+setdataStat1.toString());

        Stat setdataStat2 = zooKeeper.setData("/weizz5", "weizz5 test zk setdataStat2".getBytes(), setdataStat1.getVersion());

        System.out.println("setdataStat2:"+setdataStat2.toString());


        System.out.println("---- Async start --------");
        zooKeeper.getData("/weizz5", false, new AsyncCallback.DataCallback() {
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {

                System.out.println("rc:"+rc+",path:"+path+",ctx:"+ctx+",data:"+new String(data)+",stat:"+stat.toString());


            }
        },"test ctx");

        System.out.println(" --- Async over --------");

        Thread.sleep(15000);

    }

}

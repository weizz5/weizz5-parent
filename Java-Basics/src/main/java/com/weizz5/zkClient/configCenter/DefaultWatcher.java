package com.weizz5.zkClient.configCenter;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/09
 */
public class DefaultWatcher implements Watcher {

    private CountDownLatch latch;

    public DefaultWatcher(CountDownLatch latch) {
        this.latch = latch;
    }

    public void process(WatchedEvent event) {
        System.out.println(event.toString());

        Event.KeeperState state = event.getState();

        switch (state) {
            case Unknown:
                break;
            case Disconnected:
                break;
            case NoSyncConnected:
                break;
            case SyncConnected:
                System.out.println("DefaultWatcher SyncConnected!!!");
                latch.countDown();
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

    }
}

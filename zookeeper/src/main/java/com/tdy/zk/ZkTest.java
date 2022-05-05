package com.tdy.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ip = "192.168.161.95:4180";

        CountDownLatch countDownLatch = new CountDownLatch(1);


        ZooKeeper zooKeeper = new ZooKeeper(ip, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();

        ZooKeeper.States state = zooKeeper.getState();
        System.out.println(state.isConnected());
    }
}

package com.tdy.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.data.Stat;

public class CuratorTest {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.161.95:4180")
                .retryPolicy(new RetryForever(100))
                .build();

        curatorFramework.start();

        Stat stat = new Stat();

        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/cloudb/cloudb-jdbc/load-tables/vanke");
        System.out.println(new String(bytes));
    }
}

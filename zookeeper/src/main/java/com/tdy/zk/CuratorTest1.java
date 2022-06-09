package com.tdy.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.data.Stat;

public class CuratorTest1 {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.161.95:4180")
                .retryPolicy(new RetryForever(100))
                .build();

        curatorFramework.start();

        Stat stat = new Stat();


        ///cloudb/cloudb-jdbc/load-tables/vanke
        String nodePath = "/cloudb/cloudb-jdbc/load-tables/vanke";

        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath(nodePath);
        System.out.println(new String(bytes));


        NodeCache nodeCache = new NodeCache(curatorFramework, nodePath, false);
        nodeCache.getListenable().addListener(() -> {
            System.out.println("nodeCache:"+new String(nodeCache.getCurrentData().getData()));
        });
        nodeCache.start(false);

        while (true){

        }
    }

}

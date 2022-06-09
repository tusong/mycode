package com.tdy.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CuratorTest {

    static CuratorFramework curatorFramework;
    @BeforeAll
    public static void init() throws InterruptedException {
        curatorFramework = CuratorFrameworkFactory.builder().connectString("192.168.161.95:4180")
                .retryPolicy(new RetryForever(100))
                .build();

        curatorFramework.start();
        curatorFramework.blockUntilConnected();
    }

    @Test
    public void testC() throws Exception {

        String path = "/cloudb/cloudb-jdbc/load-tables/vanke";
        String value = UUID.randomUUID().toString();

        Stat stat = curatorFramework.checkExists().forPath(path);
        // 为空则创建节点
        if (null == stat) {
            String forPath = curatorFramework.create().creatingParentsIfNeeded().forPath(path, value.getBytes());
        }
        // 为空则修改值
        else {
            curatorFramework.setData().forPath(path, value.getBytes());
        }
    }
}

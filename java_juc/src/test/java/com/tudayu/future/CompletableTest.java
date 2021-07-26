package com.tudayu.completable;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author tusong
 * @version V1.0
 * @Package com.tudayu.completable
 * @ClassName CompletableTest.java
 * @date 2021/7/21
 * @Description: 此处添加类描述……
 */
public class CompletableTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try{
                System.out.println(Thread.currentThread().getName() + "子线程开始干活");
//子线程睡 5 秒
                Thread.sleep(5000);
//在子线程中完成主线程
                future.complete("success");
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "A").start();
//主线程调用 get 方法阻塞
        System.out.println("主线程调用 get 方法获取结果为: " + future.get());
        System.out.println("主线程完成,阻塞结束!!!!!!");


    }
}

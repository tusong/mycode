package com.tudayu.future;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author tusong
 * @version V1.0
 * @Package com.tudayu.future
 * @ClassName FutureTaskTest.java
 * @date 2021/7/21
 * @Description: 此处添加类描述……
 */
public class FutureTaskTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>( () -> 1 );

        futureTask.run();
        Integer integer = futureTask.get();

        System.out.println(integer);
    }
}

package com.e_1_5_5;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * 我们建立一个线程的scope，该scope在表示一个线程中有效，代码如下：
 */
public class MyScope implements Scope {

    private final ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        threadLocal.get();
        return null;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

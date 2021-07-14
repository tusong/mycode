package com.e_1_6_1;

import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleImpl3 implements LifecycleProcessor {
    @Override
    public void start() {
        System.out.println("LifecycleImpl3 start");
    }

    @Override
    public void stop() {
        System.out.println("LifecycleImpl3 stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifecycleImpl3 isRunning");
        return true;
    }

    @Override
    public void onRefresh() {
        System.out.println("LifecycleImpl3 onRefresh");
    }

    @Override
    public void onClose() {
        System.out.println("LifecycleImpl3 onClose");
    }
}

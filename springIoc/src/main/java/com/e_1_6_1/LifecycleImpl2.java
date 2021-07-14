package com.e_1_6_1;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifecycleImpl2 implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("LifecycleImpl2 start");
    }

    @Override
    public void stop() {
        System.out.println("LifecycleImpl2 stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifecycleImpl2 isRunning");
        return true;
    }
}

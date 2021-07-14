package com.e_1_6_1;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifecycleImpl implements Lifecycle {
    @Override
    public void start() {
        System.out.println("LifecycleImpl start");
    }

    @Override
    public void stop() {
        System.out.println("LifecycleImpl stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifecycleImpl isRunning");
        return true;
    }
}

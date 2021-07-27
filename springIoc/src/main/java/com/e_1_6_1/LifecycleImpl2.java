package com.e_1_6_1;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component()
@Lazy
public class LifecycleImpl2 implements SmartLifecycle {

    boolean isRunning;

    @Override
    public void start() {
        System.out.println("LifecycleImpl2 start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("LifecycleImpl2 stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifecycleImpl2 isRunning");
        return isRunning;
    }
}

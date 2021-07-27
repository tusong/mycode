package com.e_1_6_1;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifecycleImpl implements Lifecycle {


    boolean isRunning ;

    @Override
    public void start() {
        System.out.println("LifecycleImpl start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("LifecycleImpl stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifecycleImpl isRunning");
        return isRunning;
    }
}

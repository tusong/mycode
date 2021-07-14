package com.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassB {

//    @Autowired
//    public ClassB(ClassA classA) {
//    }

    @Autowired
    ClassA classA;
}

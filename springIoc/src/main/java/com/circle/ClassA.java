package com.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

//    @Autowired
//    public ClassA(ClassB classB) {
//    }

    @Autowired
    ClassB classB;
}

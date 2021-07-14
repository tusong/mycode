package com.e_1_6_1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Lifecycle implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass() + ":afterPropertiesSet");
    }

    @PostConstruct
    public void init(){
        System.out.println(this.getClass() + ":PostConstruct");
    }

    public void initXml(){
        System.out.println(this.getClass() + ":initXml");
    }

}

package com.e_1_6_1;

import com.e_1_4_1.AnotherBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class LifeCycleAppConfig {


    @Bean
    public AnotherBean classA (){

        return new AnotherBean();
    }

}

package com.e_1_6_1;

import com.e_1_4_1.AnotherBean;
import org.springframework.context.annotation.Bean;

//@Configuration
//@ComponentScan
public class LifeCycleAppConfig {


    @Bean
    public AnotherBean classA (){

        return new AnotherBean();
    }

}

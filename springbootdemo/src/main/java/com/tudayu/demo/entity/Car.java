package com.tudayu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tusong
 * @version V1.0
 * @Package com.tudayu.demo.entity
 * @ClassName Car.java
 * @date 2021/8/2 16:18
 * @Description: 此处添加类描述……
 */
@Data
@ToString
@AllArgsConstructor
@ConfigurationProperties(prefix = "car")
@Component
public class Car {

    private String brand;
    private int price;

}

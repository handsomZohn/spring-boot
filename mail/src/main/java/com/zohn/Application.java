package com.zohn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zohn on 2017/12/8.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(
                Application.class, args
        );
    }
}

/**
 @SpringBootApplication包含以下几个注解:
 @Configuration:表示该类作为SpringBoot配置文件类
 @EnableAutoConfiguration:程序启动，自动加载springboot默认配置
 @ComponentScan:表示程序启动时，自动扫描当前包以及包下所有类
 */
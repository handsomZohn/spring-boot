package com.zohn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zohn on 2017/12/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Test
    public void contextLoads(){
        System.out.println("hello");
    }
}

/**
@RunWith:就是一个运行器，标注由什么来运行比如:
@RunWith(JUnit4.class)就是指用JUnit4来运行
@SpringBootTest：用来测试SpringApplication
 */
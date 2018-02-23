package com.zohn.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by zohn on 2017/12/8
 *编写简单的http请求来测试；使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTests {

    private MockMvc mvc;

    @Autowired
    HelloWorldController helloWorldController;

    @Before
    public void setUp() throws  Exception{
        //需要的时候去new一个对象  改为自动装配
        //mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        mvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void sayHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}

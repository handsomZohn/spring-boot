package com.zohn.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zohn on 2017/12/8.
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "OneTwoThreeFour";
    }
}

/**

 @RestController:作用相当于@ResponseBody+@Controller何合一起的作用
 Controller上边标注了@RestController，那么相当与所有的方法都标注了@ResponseBody

 @RequestMapping:





 */
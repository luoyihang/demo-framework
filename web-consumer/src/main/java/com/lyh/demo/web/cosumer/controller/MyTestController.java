package com.lyh.demo.web.cosumer.controller;

import com.lyh.demo.dubbo.interfaces.UserDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoyihang
 * @date 2019/6/30 15:16
 */
@RestController
@RequestMapping("/test")
public class MyTestController {

    @Reference(version = "1.0.0")
    private UserDubboService userDubboService;

    @PostMapping("/test1")
    public String test1(){
        String userName = userDubboService.getUserName();
        System.out.println(userName);
        return "success";
    }
}

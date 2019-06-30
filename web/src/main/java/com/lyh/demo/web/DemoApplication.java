package com.lyh.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luoyihang
 * @date 2019/6/30 14:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyh.demo.web.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

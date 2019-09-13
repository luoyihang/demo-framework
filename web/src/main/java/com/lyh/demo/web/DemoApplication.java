package com.lyh.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author luoyihang
 * @date 2019/6/30 14:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyh.demo.web.dao")
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        MyKafkaProducer bean = context.getBean(MyKafkaProducer.class);
        for (int i = 0; i < 10; i++) {
            bean.send(i);
            TimeUnit.SECONDS.sleep(2);
        }
    }

}

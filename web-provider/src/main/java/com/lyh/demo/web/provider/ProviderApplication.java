package com.lyh.demo.web.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luoyihang
 * @date 2019/6/30 14:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyh.demo.web.provider.dao")
@EnableDubbo
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}

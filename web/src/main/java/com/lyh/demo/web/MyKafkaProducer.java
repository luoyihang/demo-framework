package com.lyh.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author LYH
 * @date 2019/9/2
 */
@Component
public class MyKafkaProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(Integer i) {
        kafkaTemplate.send("test", i, "myData");
    }
}

package com.lyh.demo.web;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author LYH
 * @date 2019/9/2
 */
@Component
public class MyKafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void listener(ConsumerRecord record) {
        Optional.ofNullable(record).ifPresent(ConsumerRecord::value);
    }
}

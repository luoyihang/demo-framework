package com.lyh.demo.web;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author LYH
 * @date 2019/9/2
 */
public class MyKafkaConsumerOld extends Thread {

    KafkaConsumer<Integer, String> consumer;
    String topic;

    public MyKafkaConsumerOld(String topic){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.102:9092,192.168.1.103:9092,192.168.1.104:9092");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "lyh-consumer");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "lyh-id");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_DOC, "earliest");
        consumer = new KafkaConsumer<>(properties);
        this.topic = topic;
    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singleton(this.topic));
        while (true) {
            ConsumerRecords<Integer, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            consumerRecords.forEach(p -> System.out.println(p.key() + "->" + p.value() + "->" + p.offset()));
        }
    }

    public static void main(String[] args) {
        new MyKafkaConsumerOld("test").start();
    }
}

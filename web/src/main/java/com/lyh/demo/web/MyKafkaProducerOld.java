package com.lyh.demo.web;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2019/9/2
 */
public class MyKafkaProducerOld extends Thread{

    KafkaProducer<Integer, String> producer;
    String topic;

    public MyKafkaProducerOld(String topic) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.102:9092,192.168.1.103:9092,192.168.1.104:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "lyh-producer");
//        properties.put(ProducerConfig.BATCH_SIZE_CONFIG);
//        properties.put(ProducerConfig.LINGER_MS_CONFIG);

        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
    }

    @Override
    public void run() {
        int num = 0;
        String msg = "lyh kafka practive msg:" + num;
        while (num < 20) {
            try {
                RecordMetadata recordMetadata =
                        producer.send(new ProducerRecord<>(topic, msg)).get();
                System.out.println(recordMetadata.offset() + "->" + recordMetadata.partition() + "->" + recordMetadata.offset());
                TimeUnit.SECONDS.sleep(2);
                ++num;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyKafkaProducerOld("test").start();
    }
}

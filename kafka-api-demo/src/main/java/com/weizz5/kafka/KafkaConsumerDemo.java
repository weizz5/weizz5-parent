package com.weizz5.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/08
 */
public class KafkaConsumerDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.1.130.101:9092,10.1.130.102:9092,10.1.130.103:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "weizz501");
//        ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        kafkaConsumer.subscribe(Arrays.asList("sysm-topic-test"));

        while (true){

            ConsumerRecords<String, String> poll = kafkaConsumer.poll(Duration.ofSeconds(1));
            if(!poll.isEmpty()){

                for (ConsumerRecord<String, String> record :  poll){
//                    System.out.println(JSON.toJSONString(record));
//                    System.out.println(record.key());
//                    System.out.println(record.partition());
//                    System.out.println(record.offset());
//                    System.out.println(record.timestamp());
                    System.out.println(record.toString());

                }
            }

        }
//        for (int i = 0; i < 10; i++) {
//            ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>("sysm-topic-test", "key0"+i, "value0"+i);
//
//            kafkaProducer.send(stringStringProducerRecord);
//
//        }

//        kafkaConsumer.close();
    }

}

package com.weizz5.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/08
 */
public class KafkaProducerDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.1.130.101:9092,10.1.130.102:9092,10.1.130.103:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        KafkaProducer<String,String> kafkaProducer = new KafkaProducer(properties);

        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>("sysm-topic-test", "key0"+i, "value0"+i);

            kafkaProducer.send(stringStringProducerRecord);

        }

        kafkaProducer.close();
    }

}

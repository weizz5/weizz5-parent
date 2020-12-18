package com.weizz5.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.admin.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/08
 */
public class KafkaTopicDml {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"10.1.130.101:9092,10.1.130.102:9092,10.1.130.103:9092");
//        properties.setProperty(AdminClientConfig.,"10.1.130.101:9092,10.1.130.102:9092,10.1.130.103:9092");

        KafkaAdminClient adminClient = (KafkaAdminClient) KafkaAdminClient.create(properties);


        CreateTopicsResult topics = adminClient.createTopics(Arrays.asList(new NewTopic("sysm-topic-test", 3, (short) 1)));
//             同步新建
        topics.all().get();

        // 删除topic
//        adminClient.deleteTopics(Arrays.asList("sysm-topic-test"));


        // topic 描述信息
//        DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Arrays.asList("sysm-data-ccp-gz"));
//        Map<String, TopicDescription> stringTopicDescriptionMap = describeTopicsResult.all().get();
//        for(Map.Entry topic : stringTopicDescriptionMap.entrySet()){
//            TopicDescription value = (TopicDescription) topic.getValue();
//
//            System.out.println("key:"+topic.getKey()+",partition size:"+value.partitions().size());
//
//        }

//        TimeUnit.SECONDS.sleep(5);

        ListTopicsResult listTopicsResult = adminClient.listTopics();
        Set<String> strings = listTopicsResult.names().get();
        System.out.println(strings.contains("sysm-topic-test"));
        System.out.println("size:"+strings.size()+",detail:"+strings);

        adminClient.close( );
    }
}

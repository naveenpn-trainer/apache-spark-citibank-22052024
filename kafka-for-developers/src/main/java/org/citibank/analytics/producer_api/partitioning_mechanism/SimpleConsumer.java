package org.citibank.analytics.producer_api.partitioning_mechanism;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.citibank.analytics.producer_api.AppConfigs;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put("group.id","group01");

        KafkaConsumer<Integer,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(AppConfigs.TOPIC_MY_DEMO_TOPIC));

        while(true){
            ConsumerRecords<Integer,String> records = consumer.poll(1000);
            for(ConsumerRecord<Integer,String> record:records){
                System.out.println(record);
            }
        }


    }
}

package org.citibank.analytics.consumer_api.without_multithreaded;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.citibank.analytics.consumer_api.ConsumerGroupUtil;
import org.citibank.analytics.producer_api.AppConfigs;

import java.util.Arrays;

public class Consumer03 {
    public static void main(String[] args) {

        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(ConsumerGroupUtil.getConsumerProperties());
        consumer.subscribe(Arrays.asList(AppConfigs.TOPIC_SIMPLE_PRODUCER_CONSUMER));

        while (true) {
            ConsumerRecords<Integer, String> records = consumer.poll(1000);
            for (ConsumerRecord<Integer, String> record : records) {
                System.out.println(record);
            }
        }

    }
}

package org.citibank.analytics.producer_api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) throws InterruptedException {
        // Step 01 : Set up the properties for the KafkaProducer
        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,AppConfigs.APPLICATION_ID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // Step 02 : Create KafkaProducer object
        KafkaProducer<Integer,String> producer = new KafkaProducer<>(properties);

        // Step 03 : Create ProducerRecord object
//        for(int i=0;i<AppConfigs.NUM_EVENTS;i++) {
            System.out.println("Sending Message");
            ProducerRecord producerRecord = new ProducerRecord(AppConfigs.TOPIC_SIMPLE_PRODUCER_CONSUMER, "Message");
            producer.send(producerRecord);
//            Thread.sleep(1000);
            System.out.println("Sleeping for 1 sec");
//        }
        producer.close();

    }
}

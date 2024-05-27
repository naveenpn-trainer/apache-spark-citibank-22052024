package org.citibank.analytics.partitioning_mechanism;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.citibank.analytics.AppConfigs;

import java.util.Properties;
import java.util.Scanner;

public class Approach04 {
    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.APPLICATION_ID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"org.citibank.analytics.partitioning_mechanism.CustomPartitioning");
        KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties);

        Scanner input = new Scanner(System.in);
        String message = null;
        String key = null;
        do {
            System.out.println("Enter key");
            key = input.nextLine();
            System.out.println("Enter message");
            message = input.nextLine();
            if (!message.equals("quit")) {
                ProducerRecord producerRecord = new ProducerRecord(AppConfigs.TOPIC_MY_DEMO_TOPIC,  key, message);
                producer.send(producerRecord);
            }
        } while (!message.equals("quit"));
        producer.close();
    }
}

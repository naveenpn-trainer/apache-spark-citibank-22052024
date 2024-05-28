package org.citibank.analytics.producer_api.partitioning_mechanism;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.citibank.analytics.producer_api.AppConfigs;

import java.util.Properties;
import java.util.Scanner;

public class Approach01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.APPLICATION_ID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties);

        Scanner input = new Scanner(System.in);
        String message = null;
         do{
            System.out.println("Sending Message");
             message = input.nextLine();
             if(!message.equals("quit")) {
                 ProducerRecord producerRecord = new ProducerRecord(AppConfigs.TOPIC_MY_DEMO_TOPIC, message);
                 producer.send(producerRecord);
             }
        }while (!message.equals("quit"));
        producer.close();
    }
}

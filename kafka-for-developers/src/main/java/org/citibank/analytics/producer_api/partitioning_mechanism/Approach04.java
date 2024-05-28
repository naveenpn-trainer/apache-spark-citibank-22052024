package org.citibank.analytics.producer_api.partitioning_mechanism;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.serialization.StringSerializer;
import org.citibank.analytics.producer_api.AppConfigs;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Approach04 {
    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.APPLICATION_ID);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"org.citibank.analytics.producer_api.partitioning_mechanism.CustomPartitioning");
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
                List<Header> headerList = new ArrayList<>();
                headerList.add(new Header() {
                    @Override
                    public String key() {
                        return "MyCustomHeader";
                    }

                    @Override
                    public byte[] value() {
                        return new byte[0];
                    }
                });
                ProducerRecord producerRecord = new ProducerRecord(AppConfigs.TOPIC_MY_DEMO_TOPIC, Integer.valueOf("1"),"1", message,headerList);
                producer.send(producerRecord);
            }
        } while (!message.equals("quit"));
        producer.close();
    }
}

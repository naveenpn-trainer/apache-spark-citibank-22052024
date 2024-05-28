package org.citibank.analytics.producer_api;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class TopicCreation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Kafka broker properties
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // Topic name and configuration
        String topicName = "my-topic";
        int numPartitions = 3;
        short replicationFactor = 1;

        // Create the topic
        AdminClient adminClient = AdminClient.create(properties);
        NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
        adminClient.createTopics(Collections.singleton(newTopic)).all().get();
        System.out.println("Topic created successfully: " + topicName);
    }
}

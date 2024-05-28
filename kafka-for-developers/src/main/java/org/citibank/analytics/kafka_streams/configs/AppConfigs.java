package org.citibank.analytics.kafka_streams.configs;

public interface AppConfigs {
    String TOPIC_SIMPLE_PRODUCER_CONSUMER = "simple-producer-consumer";
    String TOPIC_MY_DEMO_TOPIC = "my-demo-topic";
    String APPLICATION_ID = "simple_producer_consumer";
    String BOOTSTRAP_SERVERS = "localhost:9092";
    int NUM_EVENTS = 1000;
}

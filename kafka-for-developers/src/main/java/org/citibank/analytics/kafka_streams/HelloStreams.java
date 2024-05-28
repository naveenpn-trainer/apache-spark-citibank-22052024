package org.citibank.analytics.kafka_streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.citibank.analytics.kafka_streams.configs.AppConfigs;

import java.util.Properties;

public class HelloStreams {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"hello-streams");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());


        // Step 01 : Open a stream to a source topic
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String,String> kStream = streamsBuilder.stream(AppConfigs.TOPIC_SIMPLE_PRODUCER_CONSUMER);

        // Step 02 - Process the Stream
        kStream.foreach((k,v) -> System.out.println("Key= "+k+" Value= "+v));

        // Step 03 - Create a Topology
        Topology topology = streamsBuilder.build();
        KafkaStreams streams = new KafkaStreams(topology,properties);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            streams.close();
        }));





    }
}

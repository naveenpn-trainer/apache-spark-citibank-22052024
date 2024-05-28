package org.citibank.analytics.kafka_streams.app;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.citibank.analytics.kafka_streams.configs.AppConfigs;
import org.citibank.analytics.kafka_streams.util.StreamsConfigUtil;

public class _01_GreattingsStreamApp {
    public static void main(String[] args) {
        // Step 01

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String,String> greetingsKStreams = streamsBuilder.stream(AppConfigs.TOPIC_SIMPLE_PRODUCER_CONSUMER);


        // Transformation
        KStream<String,String> modifiedGreetingStream =  greetingsKStreams.mapValues((k,v) -> "Hello "+v.toUpperCase());
        modifiedGreetingStream.foreach((k,v) -> System.out.println("Key= "+k+" Value= "+v));

        // Step 03 - Create a Topology
        Topology topology = streamsBuilder.build();
        KafkaStreams streams = new KafkaStreams(topology, StreamsConfigUtil.getStreamsProperties());
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            streams.close();
        }));

    }
}

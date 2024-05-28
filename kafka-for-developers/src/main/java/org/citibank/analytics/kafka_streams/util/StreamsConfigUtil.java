package org.citibank.analytics.kafka_streams.util;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.citibank.analytics.kafka_streams.configs.AppConfigs;

import java.util.Properties;

public class StreamsConfigUtil {

    public static Properties getStreamsProperties() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "hello-streams");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BOOTSTRAP_SERVERS);
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return properties;
    }
}

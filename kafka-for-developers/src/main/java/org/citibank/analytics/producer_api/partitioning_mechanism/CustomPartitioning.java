package org.citibank.analytics.producer_api.partitioning_mechanism;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioning implements Partitioner {
    @Override
    public int partition(String s, Object key, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {
        String keyAsString = key.toString();
        if(keyAsString.equals("KAR")){
            return 0;
        } else if (keyAsString.equals("TN")) {
            return 1;
        }
        else{
            return 2;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}

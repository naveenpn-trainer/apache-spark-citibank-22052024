package org.citibank.analytics.producer_api.message_sending;

import com.google.common.base.Stopwatch;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.citibank.analytics.producer_api.AppConfigs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SynchronousMessageSending {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KafkaProducer<Integer,String> producer = new KafkaProducer<>(ProducerProperties.getProducerProperties());
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0;i<10000;i++){
            ProducerRecord record = new ProducerRecord(AppConfigs.TOPIC_SIMPLE_PRODUCER_CONSUMER, "Message");
            RecordMetadata recordMetadata = (RecordMetadata) producer.send(record).get();
            System.out.println("Message sent to partition "+recordMetadata.partition()+" Offset "+recordMetadata.offset());
        }

        long timeInSeconds = stopwatch.elapsed(TimeUnit.SECONDS);
        System.out.println("Time taken to send "+timeInSeconds);
        producer.close();

    }
}

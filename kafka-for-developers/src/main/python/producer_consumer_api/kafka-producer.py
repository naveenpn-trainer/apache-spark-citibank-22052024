from kafka import KafkaProducer

if __name__ == '__main__':

    while True:
        message = input("Enter message")
        producer = KafkaProducer(bootstrap_servers=["localhost:9092"])
        # partition = int(input("Enter partition no"))
        producer.send(topic="simple-producer-consumer",
                      value=bytes(message, encoding="utf-8"))
    producer.close()
    producer.flush()

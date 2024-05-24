# Getting Started with Apache Kafka

- [ ] Integration between components
- [ ] What is Kafka
- [ ] Components of Messaging System
- [ ] Uderstanding Kafka Components
  - [ ] Producer
  - [ ] Consumer
  - [ ] Broker
  - [ ] Cluster
  - [ ] Partitions
  - [ ] Offset
  - [ ] Consumer groups
- [ ] **Hands-on ** : Working with Kafka setup and cluster

## Integration without Messaging System

![image-20240522120643781](I:\My Drive\Training Providers\Corporate Trainings\Imarticus\CitiBank\Batch 02 - Kafka\imgs\Module 01 - Getting Started with Kafka and Core API\image-20240522120643781.png)

## Integration with Messaging System

![image-20240522120924802](I:\My Drive\Training Providers\Corporate Trainings\Imarticus\CitiBank\Batch 02 - Kafka\imgs\Module 01 - Getting Started with Kafka and Core API\image-20240522120924802.png)

## What is Kafka

> Apache Kafka is a **distributed streaming platform**

1. Producer
2. Kafka Cluster (Broker)
3. Consumer

![image-20240522121438363](I:\My Drive\Training Providers\Corporate Trainings\Imarticus\CitiBank\Batch 02 - Kafka\imgs\Module 01 - Getting Started with Kafka and Core API\image-20240522121438363.png)

### Producer

* Producer is an application which send messages to kafka cluster



## API's in Kafka

1. Producer API : Applications
2. Consumer API : 
3. Stream API
4. Kafka Connect API

![image-20240522123403837](I:\My Drive\Training Providers\Corporate Trainings\Imarticus\CitiBank\Batch 02 - Kafka\imgs\Module 01 - Getting Started with Kafka and Core API\image-20240522123403837.png)

## Core Components

1. Producer
2. Consumer
3. Broker (Nodes)
4. Cluster
5. Topic
6. Partitions
7. Offsets
8. Consumer Groups

### Producer 



### Topic

2g

3g

4g

lte

volte

5g

GN

SGSN



### Partitions





Python Apps    --> MySQL (API) ---> Database   







Producer --> M1, M2



Kafka

​	M1    --> ConsumerA

​	M2   -> 





ConsumerB



ConsumerC



P1,P2,P3  --> SalesTopic

## partitions



![image-20240522130530786](I:\My Drive\Training Providers\Corporate Trainings\Imarticus\CitiBank\Batch 02 - Kafka\imgs\Module 01 - Getting Started with Kafka and Core API\image-20240522130530786.png)

### Consumer Groups

​									PartitionA				

P1,P2,P3		-->      TopicA

​									PartitionB				ConsumerA	--->		DB



​									PartitionC



​															ConsumerB/ConumerC/D



![Image result for kafka commit logs](https://lh7-us.googleusercontent.com/lObxVw7ZhWeyql5-VvnxiioYXBUbD5Q79ppVugp5jQwnwHPssF44mktKgmgkjIpEuwhAzPzE6JpQswTiJhUOroByOX5hXteo9VeofWYHHEVwJEuM5KnU56XInA7SkHw10jIpWorjTMDp74lS00xPm2P-Hy_V480=s2048)

​									

TopicA		P1		B1

​			   P2                B2



​			  P3       	B3



​						B4

Alter the TopicA to P3
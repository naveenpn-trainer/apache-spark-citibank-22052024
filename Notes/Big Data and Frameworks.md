# Getting Started with Big Data and Frameworks

> Big Data refers to the data which is large, fast and complex type of structured, semi-structured and unstructured data generated from variety of different source, which becomes difficult to store and process using a traditional processing system.

There are two main challenges of Big Data

1. Storage : Distributed Storage System
2. Processing : MPP (Massive Parallel Processing Systems)



## Distributed System

> A Distributed System is a collection of computer systems that are physically separated but linked together

![img](https://lh7-us.googleusercontent.com/docsz/AD_4nXewLDBr9JCw6iJYf7CIjxJtPZsET5o5wmglaoCAsO2_cHCHmd3fFsjEIRtGXTeBuvov-uce4AIdJmGMhjoUhk1V7xXOHrWH_ibdJe0HHbBHBx7CrV3KIIXbC-ENMowzeBd2C3RB8bw6IVg9VVCjrM25vLY?key=ZDQI9yPkLwmZ3ZH_j9fetA)



## Hadoop

> Hadoop is a software framework that allows us to **store and process large datasets** in **parallel and distributed** fashion.

## Components of Hadoop

Hadoop consists of 3 main components

1. Storage Layer - **HDFS**
2. Data Processing Layer : **MapReduce**
3. Resource Management Layer : **YARN**

![img](https://lh7-us.googleusercontent.com/docsz/AD_4nXdXQy9Evu1vaXAnzg0GZKsBsein4P_xDdA-sIIcs6fCHNXcoUy19lz0uFXMHa3i90uEzEP6kqmXskEckA0QsJKxManh_J1mEt_DyxLLe4RYfpkWEtnUoKbMpSL7ChuI1sm4eAOEu0-hvrqjg3jP_779Ha_V?key=KG4XycolQz2vWFq2bNIfEQ)

**Important**

* <mark>MapReduce component of Hadoop is deprecated</mark>--> Apache Spark



## Hadoop Daemons

Hadoop provides 5 daemon services

1. NameNode
2. DataNode
3. SecondaryNameNode
4. ResourceManager
5. NodeManager



![img](https://lh7-us.googleusercontent.com/docsz/AD_4nXdlPklsGiVoOMvJHaU0_c7G6Kegqu1lwJ0zY51ndb06w2JYUF621QRZgJmpwZHXq-nO_AIr6sQclZ0UQ8bYKf3kqJVZGhkohmPI7wguP3zjMRh-P3zrDmiRRqZMHA9JPAhCAi0egEXXn7NjmSpukDW7_qaV?key=KG4XycolQz2vWFq2bNIfEQ)

## Master and Slave Architecture

![img](https://lh7-us.googleusercontent.com/docsz/AD_4nXdRQKhHEYUKqPTV-0A8F8LMIN9Q51I6n6QvcGYprEKR2jAsDIYWWSvaN5TrXO_-ajD3hP1ZilMbBu2HVhS8WNnN0bz2gjVqC-0eB-9zVwWqdsdoYsD0XsgP1Xaith70ADzggcqhiPJptu_HKkIlFyBscSzs?key=KG4XycolQz2vWFq2bNIfEQ)

### NameNode

* NN is responsible for maintaining/storing the metadata of your actual data.

### DataNode

* The actual data is stored on the DN

### Secondary

* Its outdated



## HDFS Block

> HDFS is a distributed and scalable file system designed for storing very large files

**File System** is a software which is responsible of breaking the file into smaller chunks.

![img](https://lh7-us.googleusercontent.com/docsz/AD_4nXfPmQtpXyZ9-HC-lL2wxTEeBkVmeM8wqceyBQlJT1pVs2w5xbZfabRueubUeoMJ5H-1a_k4xf3GurkXq6gaHeL_m08dS79gjcplg8nyjJXna74yJjGX4FojFbOLZZ-TJlAPw9qaf_nBwJSU93-bT27x821Y?key=KG4XycolQz2vWFq2bNIfEQ)

* The file is broken down into blocks of size 128 MB

300 MB -->

B1 --> 128

B2 --> 128

B3 --> 44

* The block size is configurable 128 MB in 2.x
* Each block will be replicated 3 copied (configurable)






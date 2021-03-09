#!/usr/bin/env bash

#Start Zookeper
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties


#Start Kafka
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties


#Listen Topic
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic novice-players --from-beginning

#Create Topic
$KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic novice-players --partitions 5 --replication-factor 1 --config segment.bytes=1000000
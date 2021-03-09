#!/usr/bin/env bash

export KAFKA_HOME="/Users/gustavomendez/kafka-2.5.0-src/"
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties


export KAFKA_HOME="/Users/gustavomendez/kafka-2.5.0-src/"
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

export KAFKA_HOME="/Users/gustavomendez/kafka-2.5.0-src/"
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic novice-players --from-beginning

export KAFKA_HOME="/Users/gustavomendez/kafka-2.5.0-src/"
$KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic novice-players --partitions 5 --replication-factor 1 --config segment.bytes=1000000
# TrueLogic

### Version Kafka
Version of Kafka 2.3.0

### Running Application

First we have to start zookeeper
```bash
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties
```

Then Start Kafka
```bash
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties
```

For Creating project use the next cmd
```bash
$KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --topic novice-players --partitions 5 --replication-factor 1 --config segment.bytes=1000000
```

And for reading the events:
```bash
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic novice-players --from-beginning
```

After all of that is done just run:
```bash
mvn clean install
mvn spring-boot:run
```


import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.TopicPartition

import java.time.Duration
import scala.jdk.CollectionConverters._

object Main extends App {
  val topic = "users"

  val config = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "auto.offset.reset" -> "earliest",
    "enable.auto.commit" -> "true",
    "group.id" -> "test6664"
  ).asJava

  val deserializer = new StringDeserializer()
  val consumer = new KafkaConsumer[String, String](config, deserializer, deserializer)
  consumer.assign(List(new TopicPartition(topic,0)).asJava)
  println(consumer.assignment())

  while (true) {
    val records = consumer.poll(Duration.ofMillis(1000))
    for (record <- records.asScala) println(record.value())
  }
}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

import scala.jdk.CollectionConverters._
import scala.util.{Random, Try}

object Main extends App {
  val topic = "users"

  val config = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
  ).asJava

  val serializer = new StringSerializer()
  val producer = new KafkaProducer[String, String](config, serializer, serializer)

  for(_ <- 1 to 3) {
    producer.send(new ProducerRecord[String, String](topic, Random.alphanumeric.take(5).mkString, Random.alphanumeric.take(5).mkString))
  }

  producer.flush()
  producer.close()
}
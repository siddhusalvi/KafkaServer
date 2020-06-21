import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util
import java.util.Properties

import org.apache.kafka.clients.producer._
import org.apache.kafka.common.serialization.{Deserializer, Serializer}

object Producer {

  def main(args: Array[String]): Unit = {
    val topic = "kafka"
    val port = 9092
    val file = "src/main/resourece/data.json"
    writeToKafka(topic,port,file)
  }

  def writeToKafka(topic: String,port:Int,file:String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:"+port.toString)
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)

    val bufferedSource = io.Source.fromFile(file )
    for (line <- bufferedSource.getLines) {
      val txt = line+"\n"
      val record = new ProducerRecord[String, String](topic, "key", txt)
      producer.send(record)
    }
    bufferedSource.close
    producer.close()
  }
}


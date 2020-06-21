import java.io.{ObjectInputStream, ByteArrayInputStream}
import java.util

import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import java.io.{ObjectOutputStream, ByteArrayOutputStream}
import java.util
import org.apache.kafka.common.serialization.Serializer

class CustomDeserializer extends Deserializer[User]{

  override def configure(configs: util.Map[String,_],isKey: Boolean):Unit = {

  }
  override def deserialize(topic:String,bytes: Array[Byte]) = {
    val byteIn = new ByteArrayInputStream(bytes)
    val objIn = new ObjectInputStream(byteIn)
    val obj = objIn.readObject().asInstanceOf[User]
    byteIn.close()
    objIn.close()
    obj
  }
  override def close():Unit = {

  }

}



class CustomSerializer extends Serializer[User]{

  override def configure(configs: util.Map[String,_],isKey: Boolean):Unit = {

  }


  override def serialize(topic:String, data:User):Array[Byte] = {
    try {
      val byteOut = new ByteArrayOutputStream()
      val objOut = new ObjectOutputStream(byteOut)
      objOut.writeObject(data)
      objOut.close()
      byteOut.close()
      byteOut.toByteArray
    }
    catch {
      case ex:Exception => throw new Exception(ex.getMessage)
    }
  }

  override def close():Unit = {

  }


}
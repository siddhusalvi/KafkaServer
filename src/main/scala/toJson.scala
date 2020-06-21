import java.io.FileWriter
import com.google.gson.Gson
import scala.collection.mutable.ListBuffer
import scala.io.Source

case class User(id: String, count: Int)

case class Data(DateTime: String,
                Cpu_Count: Int,
                Cpu_Working_Time: Double,
                Cpu_Idle_Time: Double,
                Cpu_Percent: Double,
                Usage_Cpu_Count: Int,
                Software_interrupts: Int,
                System_calls: Int,
                Interrupts: Int,
                Load_Time_1_min: Double,
                Load_Time_5_min: Double,
                Load_Time_15_min: Double,
                Total_Memory: Double,
                Used_Memory: Double,
                Free_Memory: Double,
                Active_Memory: Double,
                Inactive_Memory: Double,
                Bufferd_Memory: Double,
                Cache_Memory: Double,
                Shared_Memory: Double,
                Available_Memory: Double,
                Total_Disk_Memory: Double,
                Used_Disk_Memory: Double,
                Free_Disk_Memory: Double,
                Read_Disk_Count: Int,
                Write_Disk_Count: Int,
                Read_Disk_Bytes: Double,
                Write_Disk_Bytes: Double,
                Read_Time: Int,
                Write_Time: Int,
                IO_Time: Int,
                Bytes_Sent: Double,
                Bytes_Received: Double,
                Packets_Sent: Int,
                Packets_Received: Int,
                Errors_While_Sending: Int,
                Errors_While_Receiving: Int,
                Incoming_Packets_Dropped: Int,
                Outgoing_Packets_Dropped: Int,
                Boot_Time: String,
                User_Name: String,
                Keyboard: Double,
                Mouse: Double,
                Technologies: String,
                Files_Changed: Int
               )


object toJson {

  def main(args: Array[String]): Unit = {

    var records = ListBuffer[Data]()
    val path = "src/main/resourece/data.csv"
    val lines = Source.fromFile(path).getLines.toList
    val gson = new Gson()
    val jsonfile = "src/main/resourece/Userdata.json"
    val writer = new FileWriter(jsonfile)

    for (index <- 0 until (lines.length)) {
      writer.write(gson.toJson(toUser(lines(index).split(","))) + "\n")
    }
    writer.close()
  }

  def toUser(arr: Array[String]): User = {
    var record = User(id = arr(0).toString,
      count = arr(1).toInt
    )
    record
  }

  def toData(arr: Array[String]): Data = {
    var record =
      Data(DateTime = arr(0).toString,
        Cpu_Count = arr(1).toInt,
        Cpu_Working_Time = arr(2).toDouble,
        Cpu_Idle_Time = arr(3).toDouble,
        Cpu_Percent = arr(4).toDouble,
        Usage_Cpu_Count = arr(5).toInt,
        Software_interrupts = arr(6).toInt,
        System_calls = arr(7).toInt,
        Interrupts = arr(8).toInt,
        Load_Time_1_min = arr(9).toDouble,
        Load_Time_5_min = arr(10).toDouble,
        Load_Time_15_min = arr(11).toDouble,
        Total_Memory = arr(12).toDouble,
        Used_Memory = arr(13).toDouble,
        Free_Memory = arr(14).toDouble,
        Active_Memory = arr(15).toDouble,
        Inactive_Memory = arr(16).toDouble,
        Bufferd_Memory = arr(17).toDouble,
        Cache_Memory = arr(18).toDouble,
        Shared_Memory = arr(19).toDouble,
        Available_Memory = arr(20).toDouble,
        Total_Disk_Memory = arr(21).toDouble,
        Used_Disk_Memory = arr(22).toDouble,
        Free_Disk_Memory = arr(23).toDouble,
        Read_Disk_Count = arr(24).toInt,
        Write_Disk_Count = arr(25).toInt,
        Read_Disk_Bytes = arr(26).toDouble,
        Write_Disk_Bytes = arr(27).toDouble,
        Read_Time = arr(28).toInt,
        Write_Time = arr(29).toInt,
        IO_Time = arr(30).toInt,
        Bytes_Sent = arr(31).toDouble,
        Bytes_Received = arr(32).toDouble,
        Packets_Sent = arr(33).toInt,
        Packets_Received = arr(34).toInt,
        Errors_While_Sending = arr(35).toInt,
        Errors_While_Receiving = arr(36).toInt,
        Incoming_Packets_Dropped = arr(37).toInt,
        Outgoing_Packets_Dropped = arr(38).toInt,
        Boot_Time = arr(39).toString,
        User_Name = arr(40).toString,
        Keyboard = arr(41).toDouble,
        Mouse = arr(42).toDouble,
        Technologies = arr(43).toString,
        Files_Changed = arr(44).toInt
      )
    record
  }

}
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

import java.util.Properties

object FlinkApp extends App {
  val properties = new Properties()
  properties.setProperty("bootstrap.servers", "localhost:9092")
  properties.setProperty("group.id", "string")
  properties.setProperty("auto.offset.reset.config", "earliest")

  val consumer = new FlinkKafkaConsumer("topic-string", new SimpleStringSchema(), properties)

  //consumer.assignTimestampsAndWatermarks(WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(20)))

  val env = StreamExecutionEnvironment.getExecutionEnvironment
  val stream = env.addSource(consumer)
  stream.print()
  env.execute()
}

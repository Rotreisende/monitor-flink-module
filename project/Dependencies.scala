import sbt._

object Dependencies {
  val flink = Seq(
    "org.apache.flink" %% "flink-streaming-scala" % versions.flink,
    "org.apache.flink" %% "flink-clients" % versions.flink
  )

  val kafkaConnector = Seq {
    "org.apache.flink" %% "flink-connector-kafka" % versions.flinkConnector
  }

  object versions {
    val flink = "1.13.2"
    val flinkConnector = "1.13.1"
  }
}

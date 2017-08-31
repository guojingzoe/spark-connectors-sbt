package com.zqh.spark.connectors.mongo

import com.zqh.spark.connectors.ConnectorsReadConf
import com.zqh.spark.connectors.test.{TestSparkConnectors, TestSparkWriter}
import org.apache.spark.sql.SparkSession

/**
  * Created by zhengqh on 17/8/30.
  *
  * https://github.com/StevenSLXie/Tutorials-for-Web-Developers/blob/master/MongoDB%20%E6%9E%81%E7%AE%80%E5%AE%9E%E8%B7%B5%E5%85%A5%E9%97%A8.md
  */
object TestMongoReader {
  def main(args: Array[String]) {
    val readConf = new ConnectorsReadConf("mongo")
      .setReadConf("db", "tutorial")
      .setReadConf("table", "movie")

    val spark = SparkSession.builder().master("local").config(readConf).getOrCreate()

    val reader = new MongoReader(readConf)
    val writer = new TestSparkWriter()

    val connector = new TestSparkConnectors(reader, writer, spark)
    connector.runSparkJob()
  }
}
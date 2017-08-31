package com.zqh.spark.connectors.core

import com.zqh.spark.connectors.test.TestSparkWriter
import com.zqh.spark.connectors.test.{TestSparkWriter, TestSparkReader}
import org.apache.spark.sql.SparkSession

/**
  * Created by zhengqh on 17/8/29.
  */
object TestSparkConnectorApp {

  def main(args: Array[String]) {
    val reader = new TestSparkReader()
    val writer = new TestSparkWriter()

    val spark = SparkSession.builder().master("local").getOrCreate()

    val source = reader.read(spark)
    writer.write(source)
  }
}


package org.scala.datapipeline

import org.apache.spark.sql.SparkSession
import org.scala.datapipeline.core.utils.{ClassLoaderUtils, ConfFactory}

object Main {
  def getSparkSession(confFactory: ConfFactory): SparkSession = {
    val builder: SparkSession.Builder = SparkSession
      .builder()
      .appName(confFactory.application)

    val spark: SparkSession = {
      if (confFactory.env.equals("local")) {
        builder.master("local[*]")
      } else {
        builder
      }
    }.getOrCreate()

    spark
  }

  def process(confFactory: ConfFactory): Unit = {
    val spark = getSparkSession(confFactory)

  }

  def main(args: Array[String]): Unit = {

    require(args.length>=0, "method should have configuration path!!")
      println()
    lazy val path: String = "file_path"
    lazy val format: String = "json"
    lazy val options: Map[String, String] = Map.empty[String, String]
    lazy val applicationName = "localMode"
    lazy val isLocal = true

    implicit  val spark = SparkSession.builder()
                    .appName(applicationName)
                    .master("local")
                    .getOrCreate()

    import spark.implicits._

    val df = Seq((1,"adarsh")).toDF("id", "name")

    val context = Map("test"->df)

    val obj = new ClassLoaderUtils().load[BaseDrivedDataSet]("org.scala.datapipeline.Transform")
    val dd = obj.compute(context)

    dd.show()

  }
}
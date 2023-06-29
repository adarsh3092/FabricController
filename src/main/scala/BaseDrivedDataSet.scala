package org.scala.datapipeline

import org.apache.spark.sql.{Dataset, Row, SparkSession}

trait BaseDrivedDataSet {
  def compute(context:Map[String, Dataset[Row]])(implicit spark: SparkSession): Dataset[Row]

}

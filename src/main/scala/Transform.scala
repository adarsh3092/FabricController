package org.scala.datapipeline

import org.apache.spark.sql.{Dataset, Row, SparkSession}

object Transform extends BaseDrivedDataSet {
  override def compute(context: Map[String, Dataset[Row]])
                      (implicit spark: SparkSession): Dataset[Row] = {


   val df = context.getOrElse("test", spark.emptyDataFrame)

    df.groupBy("id").count()
  }
}

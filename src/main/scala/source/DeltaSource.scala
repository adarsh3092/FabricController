package org.scala.datapipeline
package source

import core.utils.ConfFactory

import org.apache.spark.sql.SparkSession

object DeltaSource extends ControllerSource {

  def readDelta(confFactory: ConfFactory)(implicit spark: SparkSession): Unit = {

      spark.read.format(format)
  }
}

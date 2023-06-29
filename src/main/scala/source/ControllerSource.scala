package org.scala.datapipeline.source

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scala.datapipeline.core.utils.ConfFactory

 class ControllerSource {
   var format: String = _
   var sourceType: String= _
   var path: String = _
   var options :Map[String,String] = _
  def read(confFactory: ConfFactory)(implicit spark:SparkSession) = {
      format = confFactory.source.map(_.format).head
      sourceType = confFactory.source.map(_.source_type).head
      path = confFactory.source.map(_.path).head.get
      options =confFactory.source.map(_.options).head.get

    lazy val dataframe: DataFrame =  sourceType match {
            case "kafka" =>
                println("kafka source support under development!!")
                spark.emptyDataFrame

            case "file" => {
              format match {

                case "delta" =>  {
                  println("delta source reading!!!")
                  spark.emptyDataFrame
                }
                case "csv"=> {
                    spark.read.options(options).format(format).load(path)
                }

                case _ => throw new UnsupportedOperationException(s"This ${format} doestn't support fabric controller!!")

              }
            }
             case _ => throw new IllegalArgumentException(s"unsupported source type ${sourceType}")
                }

    dataframe
  }

  }

object ControllerSource {
def apply(confFactory: ConfFactory)(implicit spark: SparkSession): DataFrame = {
      val inputDf = new ControllerSource().read(confFactory)
      inputDf
}

}

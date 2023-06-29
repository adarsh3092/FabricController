package org.scala.datapipeline
package sink

import core.utils.Sink

abstract class SinkController {
  var path:String = _
  var formate:String = _
  var isPartitionBy:Boolean = _
  var partitionColumns:List[String] = _
  def write(sinkConf: Sink): Unit = {

    formate

  }

  }
object SinkController{

}

package org.scala.datapipeline
import org.scala.datapipeline.source._
import core.utils.ControllerFactory

object SourceControllerTest {

  def main(args:Array[String]): Unit = {

    val path  = "/Users/adarshjain/Desktop/learning/FabricController/ruuner.json"

    val confFactory = ControllerFactory.getConf(Option(path))
    implicit val spark = Main.getSparkSession(confFactory)
     val dd = ControllerSource(confFactory)
    dd.show()

  }

}

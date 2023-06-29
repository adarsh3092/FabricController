package org.scala.datapipeline
import org.json4s._
import org.json4s.jackson.JsonMethods._

import java.io.FileNotFoundException
import scala.io.BufferedSource
case class Source(format:String,
                 path:Option[String],
                 bootstrap_server: Option[String],
                 topic: Option[String])

case class Sink(mode: Option[String] = None,
                format:String ,
                path: Option[String] =None
               )
case class RunnerFactor( application: String,
                        classname: String,
                        source: Option[List[Source]]=None,
                        sink: Option[List[Sink]] = None)


object RunnerFactoryTest {
  lazy val path = "/Users/adarshjain/Desktop/learning/FabricController/conf/ruuner.json"
  implicit val formats = DefaultFormats
  def main(args:Array[String]): Unit = {
    val confFile = scala.io.Source.fromFile(path).mkString
    val jsValue = parse(confFile).extract[RunnerFactor]



  }

}

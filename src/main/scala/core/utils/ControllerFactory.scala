package org.scala.datapipeline
package core.utils

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse
import org.scala.datapipeline
object ControllerFactory {
  implicit val formats = DefaultFormats
def getConf(path: Option[String]): ConfFactory = {

  val factoryObject: ConfFactory = path match {
    case  Some(_path)=>{
      val confFile = scala.io.Source.fromFile(_path).mkString
      parse(confFile).extract[ConfFactory]
    }
    case _=> throw new IllegalArgumentException("Path doesn't exits for configuration!!")
  }
    factoryObject
    }

}

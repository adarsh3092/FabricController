package org.scala.datapipeline
package core.utils

case class ConfFactory( application: String,
                        classname: String,
                        env: String = "local",
                        source: List[Source],
                        sink: List[Sink])

case class Source(format:String,
                  source_type: String,
                  path: Option[String],
                  bootstrap_server: Option[String],
                  options: Option[Map[String, String]],
                  topic: Option[String])

case class Sink(mode: Option[String] = None,
                format:String ,
                path: Option[String] =None
               )

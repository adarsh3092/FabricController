package org.scala.datapipeline
package core.utils
import scala.reflect.runtime.universe
import org.apache.spark.internal.Logging

class ClassLoaderUtils extends  Logging{
  def load[T](className: String): T = {
    try {
      val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
      val module = runtimeMirror.staticModule(className)

      val obj = runtimeMirror.reflectModule(module)
      obj.instance.asInstanceOf[T]

    }
    catch {

      case e:ClassNotFoundException => throw new ClassNotFoundException
    }
  }



}

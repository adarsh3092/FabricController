package org.scala.datapipeline
import core.utils._

trait TestTrait{
  def printData()
}

object TestObj extends TestTrait{

  def printData():Unit = println("Helllo")
}
object ClassLoaderTest {
  def main(arsg:Array[String]): Unit = {
    val obj = new ClassLoaderUtils().load[TestTrait]("org.scala.datapipeline.TestObj")
      obj.printData()
  }

}

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "FabricController",
    idePackagePrefix := Some("org.scala.datapipeline")
  )

lazy val scope = "provide"
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.4.0"
libraryDependencies += "io.delta" %% "delta-core" % "2.4.0"


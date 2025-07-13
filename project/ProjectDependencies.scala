import Versions.*
import sbt.*
import sbt.Keys.*

object ProjectDependencies {

  lazy val dependencies: Seq[Setting[?]] = Seq(
    libraryDependencies ++= {
      Seq(
//        "org.scala-lang.modules" %% "scala-collection-compat" % scalaCollectionCompat,
        "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
        "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % jacksonVersion,
        "io.github.mullerhai" % "storch-pickle_3" % "0.1.2",
        "io.github.mullerhai" % "storch-numpy_3" % "0.1.3",
        "io.github.mullerhai" % "storch-safe-tensor_3" % "0.1.0",
        // https://mvnrepository.com/artifact/org.apache.avro/avro
         "org.apache.avro" % "avro" % "1.12.0",
        "org.apache.parquet" % "parquet-avro" % "1.15.2",
        "org.apache.avro" % "avro-compiler" % "1.12.0",
        "org.apache.avro" % "avro-ipc" % "1.12.0"
      ) ++
        (if (false)  //(if (!priorTo213(scalaVersion.value))
           Seq(
//             "org.scala-lang.modules" %% "scala-parallel-collections" % scalaParallelCollections
           )
         else Nil) ++
        (
          scalaVersion.value match {
            // Only include scala-reflect for Scala 2
            case v if v.startsWith("2.") => Seq("org.scala-lang" % "scala-reflect" % v)
            // No scala-reflect for Scala 3
            case _ => Seq.empty
          }
        )
    }
  )

}

object Versions {
  val scalaCollectionCompat = "2.12.0"
  val scalaParallelCollections = "1.1.0"
  val jacksonVersion = "2.18.2"
}

import Utils.nativeRoot
import sbt.*
import sbt.Keys.*
import sbtassembly.AssemblyPlugin.autoImport.*

object GeneralSettings {

//  val scala212 = "2.12.20"
//  val scala213 = "2.13.15"
  val scala33 = "3.6.4"

  val defaultScalaVersion: String = scala33 //scala213
  val supportedScalaVersions: Seq[String] = Seq(scala33) //scala212, scala213,

  lazy val commonSettings = Seq(
    organization :=  "io.github.mullerhai",//"org.polars",
    versionScheme := Some("early-semver"),
    licenses := List("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        id = "chitralverma",
        name = "Chitral Verma",
        email = "chitral.verma@gmail.com",
        url = url("https://github.com/chitralverma")
      ),
      Developer(
        id = "mullerhai",
        name = "muller helen",
        email = "mullerhelen@gmail.com",
        url = url("https://github.com/mullerhai/storch-polar")
      )
    ),
    scalaVersion := defaultScalaVersion,
    crossScalaVersions := supportedScalaVersions,
    scalacOptions ++= Seq(
//      "-encoding",
//      "utf8",
//      "-deprecation",
//      "-feature",
//      "-language:existentials",
//      "-language:implicitConversions",
//      "-language:reflectiveCalls",
//      "-language:higherKinds",
//      "-language:postfixOps",
//      "-unchecked",
//      "-Xfatal-warnings" //
    ),
//    ++ (if (priorTo213(scalaVersion.value)) Seq("-target:jvm-1.8")
//          else Seq("-release", "8")),
    fork := true,
    turbo := true,
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )

  lazy val settings: Seq[Setting[?]] = Seq(
    name := "storch-polars", //"scala-polars",
    nativeRoot := baseDirectory.value.toPath.resolveSibling("native").toFile
  )

}

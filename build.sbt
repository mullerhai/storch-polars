
import sbt.*
import Keys.*
import sbt.Def.settings
import DocSettings.*
import Utils.{nativeRoot}
import scala.collection.Seq
lazy val root = (project in file("core"))
  .settings(
    name := "storch-polars",
    git.remoteRepo :=  "git@github.com:mullerhai/storch-polar.git"
  )  .settings(ProjectDependencies.dependencies)
    .settings(GeneralSettings.commonSettings)
  //  .settings(PublishingSettings.settings)
  .settings(
    nativeRoot := baseDirectory.value.toPath.resolveSibling("native").toFile,
    inConfig(Compile)(NativeBuildSettings.settings)
  )
  .settings(ExtraCommands.commands)
  .settings(ExtraCommands.commandAliases)


ThisBuild / tlBaseVersion := "0.0" // your current series x.y
//ThisBuild / CoursierCache := file("D:\\coursier")
ThisBuild / organization := "io.github.mullerhai" //"dev.storch"
ThisBuild / organizationName := "storch.dev"
ThisBuild / startYear := Some(2024)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(
  // your GitHub handle and name
  tlGitHubDev("mullerhai", "mullerhai")
)
ThisBuild / version := "0.1.3"

ThisBuild / scalaVersion := "3.6.4"
ThisBuild / tlSonatypeUseLegacyHost := false

import xerial.sbt.Sonatype.sonatypeCentralHost
ThisBuild / sonatypeCredentialHost := sonatypeCentralHost

import ReleaseTransformations._
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("+publishSigned"),
  releaseStepCommandAndRemaining("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges,
)

ThisBuild / tlSitePublishBranch := Some("master")

ThisBuild / apiURL := Some(new URL("https://storch.dev/api/"))
ThisBuild / tlSonatypeUseLegacyHost := false

// publish website from this branch
ThisBuild / tlSitePublishBranch := Some("master")
ThisBuild / homepage := Some(new URL("https://storch.dev/api/"))
ThisBuild / scmInfo := Some( ScmInfo( url( "https://github.com/mullerhai/storch-polars" ), "scm:git:https://github.com/mullerhai/storch-polars.git" ) )
// https://mvnrepository.com/artifact/org.projectlombok/lombok
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % "2.19.0"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
libraryDependencies += "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.19.0"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.19.0"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.19.0"
libraryDependencies += "io.github.mullerhai" % "storch-pickle_3" % "0.1.0"
libraryDependencies += "io.github.mullerhai" % "storch-numpy_3" % "0.1.0"
libraryDependencies += "io.github.mullerhai" % "storch-safe-tensor_3" % "0.1.0"

ThisBuild  / assemblyMergeStrategy := {
  case v if v.contains("module-info.class")   => MergeStrategy.discard
  case v if v.contains("UnusedStub")          => MergeStrategy.first
  case v if v.contains("aopalliance")         => MergeStrategy.first
  case v if v.contains("inject")              => MergeStrategy.first
  case v if v.contains("jline")               => MergeStrategy.discard
  case v if v.contains("scala-asm")           => MergeStrategy.discard
  case v if v.contains("asm")                 => MergeStrategy.discard
  case v if v.contains("scala-compiler")      => MergeStrategy.deduplicate
  case v if v.contains("reflect-config.json") => MergeStrategy.discard
  case v if v.contains("jni-config.json")     => MergeStrategy.discard
  case v if v.contains("git.properties")      => MergeStrategy.discard
  case v if v.contains("reflect.properties")      => MergeStrategy.discard
  case v if v.contains("compiler.properties")      => MergeStrategy.discard
  case v if v.contains("scala-collection-compat.properties")      => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}

// https://mvnrepository.com/artifact/org.xerial.snappy/snappy-java
//libraryDependencies += "org.xerial.snappy" % "snappy-java" % "1.1.10.7"
//// https://mvnrepository.com/artifact/org.lz4/lz4-java
//libraryDependencies += "org.lz4" % "lz4-java" % "1.8.0"
//// https://mvnrepository.com/artifact/com.ning/compress-lzf
//libraryDependencies += "com.ning" % "compress-lzf" % "1.1.2"
//// https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
//libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.17.0"
//// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
//libraryDependencies += "org.slf4j" % "slf4j-api" % "2.1.0-alpha1"
//// https://mvnrepository.com/artifact/commons-io/commons-io
//libraryDependencies += "commons-io" % "commons-io" % "2.19.0"
//// https://mvnrepository.com/artifact/com.google.jimfs/jimfs
//libraryDependencies += "com.google.jimfs" % "jimfs" % "1.3.0" % Test
// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml




//    nativeRoot := baseDirectory.value.toPath.resolveSibling("native").toFile,
//lazy val root = project
//  .enablePlugins(NoPublishPlugin)
//  .in(file("."))
////  .aggregate(core, vision, examples, docs)
//  .settings(
//    javaCppVersion := (ThisBuild / javaCppVersion).value,
////    csrCacheDirectory := file("D:\\coursier"),
//  )

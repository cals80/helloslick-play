name := """testgentables"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).
  enablePlugins(PlayScala).
  enablePlugins(GenerateTables)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.slick"  %% "slick"                % "3.1.1",
  "com.typesafe.slick"  %% "slick-codegen"        % "3.1.1",
  "mysql"               % "mysql-connector-java"  % "5.1.38"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

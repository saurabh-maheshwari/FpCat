name := "FpCats"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies +=
  "org.typelevel" %% "cats-core" % "1.6.0"
scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification",
  "-language:higherKinds"
)
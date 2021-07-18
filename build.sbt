
name := "armeria-scala-boilerplate"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("app")

lazy val protocol = (project in file("protocol"))
  .enablePlugins(GrpcPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "io.grpc" % "grpc-protobuf" % "1.27.0",
      "io.grpc" % "grpc-stub" % "1.27.0"
    )
  )

lazy val root = (project in file("server"))
  .settings(
    name := "scala-armeria",
    libraryDependencies ++= Seq(
      "com.linecorp.armeria" % "armeria" % "1.9.2",
      "com.linecorp.armeria" %% "armeria-scala" % "1.9.2",
      "com.linecorp.armeria" % "armeria-graphql" % "1.9.2",
      "com.linecorp.armeria" % "armeria-grpc" % "1.9.2",
      "io.micrometer" % "micrometer-registry-elastic" % "1.3.5",
      "com.typesafe" % "config" % "1.4.0",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    ),
    externalResolvers := externalResolvers.value // Resolver.combineDefaultResolvers(resolvers.value.toVector, false)
  ).dependsOn(protocol)
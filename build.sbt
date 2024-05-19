ThisBuild / scalaVersion := "2.13.12"

lazy val producer = (project in file("producer"))
  .settings(
    name := "producer",
    libraryDependencies ++= List(
      "org.apache.kafka" % "kafka-clients" % "3.7.0",
    )
  )

lazy val consumer = (project in file("consumer"))
  .settings(
    name := "consumer",
    libraryDependencies ++= List(
      "org.apache.kafka" % "kafka-clients" % "3.7.0",
    )
  )
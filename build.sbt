name := "KafkaSender"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.0.0"

//libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"

//libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.8"

//libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"


libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.1"

libraryDependencies += "de.heikoseeberger" %% "akka-http-play-json"   % "1.20.0"

libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"

libraryDependencies += "net.manub" %% "scalatest-embedded-kafka" % "0.14.0" % "test"

libraryDependencies +=  "org.slf4j" % "slf4j-api" % "1.7.5"

libraryDependencies +=  "org.slf4j" % "slf4j-simple" % "1.7.5")

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.6"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.0"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.5"



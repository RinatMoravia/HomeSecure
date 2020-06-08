lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """homesecure""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      ws,
      "com.typesafe.play" %% "play-ahc-ws-standalone" % "2.1.2"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )

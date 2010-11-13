import sbt._

class Build(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject {
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"

  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0.M2" withSources
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.14" % "test"
  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"

  val specs = "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5" % "test" withSources
  val junit = "junit" % "junit" % "4.7" % "test" withSources
  val mockito = "org.mockito" % "mockito-all" % "1.8.5" % "test" withSources
  val scalatraSpecs = "org.scalatra" %% "scalatra-specs" % "2.0.0.M2" % "test" withSources

  override lazy val jetty = runTask(Some("EmbeddedJetty"), runClasspath +++ testClasspath).dependsOn(testCompile, copyResources) describedAs "Runs jetty."

}

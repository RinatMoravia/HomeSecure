package entities

case class FileLine(id: String, name: String, mac: String, userAgent: String) extends Csv{

  override def getFileLine: List[String] = List(id, name, mac, userAgent)
}

object FileLine{
  def apply(string: String): FileLine = {
    val arr = string.split(",")
      .map(removeRedundancy)
    new FileLine(arr(0),arr(1), arr(2), arr(3))
  }

  val csvSchema = List("id", "name", "mac", "userAgent")

  private def removeRedundancy(string: String): String = {
    string.tail.stripSuffix('"'.toString)
  }
}

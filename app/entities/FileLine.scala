package entities

case class FileLine(id: String, name: String, mac: String, userAgent: String)

object FileLine{
  def apply(string: String): FileLine = {
    val arr = string.split(",")
      .map(removeRedundancy)
    new FileLine(arr(0),arr(1), arr(2), arr(3))
  }

  private def removeRedundancy(string: String): String = {
    string.tail.stripSuffix('"'.toString)
  }
}

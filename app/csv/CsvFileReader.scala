package csv

import entities.FileLine

import scala.io.Source

case class CsvFileReader(fileName: String) {

  private val source = Source.fromFile(fileName)
  final val lineIterator = source.getLines().map(FileLine(_))

  def readLine: Option[FileLine] = lineIterator.nextOption()

  def closeFile(): Unit = source.close()

}
dfdf

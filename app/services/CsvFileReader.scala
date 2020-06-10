package services

import entities.FileLine

import scala.io.Source

case class CsvFileReader(fileName: String) {

  private val source = Source.fromFile(fileName)
  private val lineIterator = source.getLines()

  def getLine: FileLine = FileLine(lineIterator.next())

  def closeFile(): Unit = source.close()

}

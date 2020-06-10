package services

import entities.FileLine

import scala.io.Source

trait CsvFile {

  def readingFromFile(file: String) = {
    val source = Source.fromFile(file)
    for (line <- source.getLines()) {
      val device = FileLine(line)
      println(device)
    }
    source.close()
  }

}

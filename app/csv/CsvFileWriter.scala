package csv

import java.io.{BufferedWriter, FileWriter}

import au.com.bytecode.opencsv.CSVWriter

case class CsvFileWriter(fileName: String) {

  private val outputFile = new BufferedWriter(new FileWriter(fileName))
  private val csvWriter = new CSVWriter(outputFile)

  def writeNextLine(string: String*): Unit = {
    csvWriter.writeNext(string.toArray:_*)
  }

  def closeFile(): Unit = outputFile.close()

}

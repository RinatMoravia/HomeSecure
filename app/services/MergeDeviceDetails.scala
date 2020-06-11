package services

import java.util.concurrent.TimeUnit.SECONDS

import entities.{DeviceInfoDto, DeviceInfoEntity, FileLine, MergedCsvFile}
import src.Conf

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration.Duration


case class MergeDeviceDetails(conf: Conf) {

  import conf._


  def MergeFileAndDeviceDetails(): Unit = {
    for (fileLine <- csvFileReader.lineIterator) {
      val deviceInfoEntity = deviceDao.getDeviceInfo(fileLine.userAgent)

      deviceInfoEntity.map(writeLineToOutputFile(fileLine, _))
        .getOrElse {
          val f = apiService.getDevicesDetails(fileLine.userAgent)
            .map(handleResponseDeviceInfo(fileLine, _))
          Await.result(f, Duration(5, SECONDS))
        }
    }
  }

  def closeFiles() = {
    csvFileReader.closeFile()
    csvFileWriter.closeFile()
  }

  def initFiles() = {
    csvFileReader.readLine //read first line
    csvFileWriter.writeNextLine(MergedCsvFile.csvSchema: _*) //write headers
  }

  private def writeLineToOutputFile(fileLine: FileLine, deviceInfoEntity: DeviceInfoEntity): Unit = {
    val deviceInfoDto = DeviceInfoDto(deviceInfoEntity)
    val mergedCsvFile = MergedCsvFile(fileLine, deviceInfoDto)
    csvFileWriter.writeNextLine(mergedCsvFile.getFileLine: _*)
  }

  private def handleResponseDeviceInfo(fileLine: FileLine, deviceInfoDto: DeviceInfoDto): Unit = {
    deviceDao.insertDeviceInfo(fileLine.userAgent, deviceInfoDto)
    val mergedCsvFile = MergedCsvFile(fileLine, deviceInfoDto)
    csvFileWriter.writeNextLine(mergedCsvFile.getFileLine: _*)
  }
}

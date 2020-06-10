package src

import com.google.inject.{Guice, Injector}
import csv.{CsvFileReader, CsvFileWriter}
import dao.DeviceInfoDao
import play.api.libs.ws.WSClient
import services.ApiService

case class Conf(fileName: String, accessKey: String, outputFileName: String) {
  val injector: Injector = Guice.createInjector(new Module)
  val wsClient: WSClient = injector.getInstance(classOf[WSClient])
  val apiService = new ApiService(wsClient, accessKey)
  val deviceDao: DeviceInfoDao = injector.getInstance(classOf[DeviceInfoDao])
  val csvFileReader: CsvFileReader = CsvFileReader(fileName)
  val csvFileWriter: CsvFileWriter = CsvFileWriter(outputFileName)
}

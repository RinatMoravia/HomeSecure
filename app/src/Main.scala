package src

import com.google.inject.Guice
import dao.DeviceDao
import entities.FileLine
import services.ApiService

import scala.io.Source

object Main extends App {

  if (args.length != 1){
    println("bad input")
    System.exit(1)
  }
  val injector = Guice.createInjector(new Module)
  val apiService = injector.getInstance(classOf[ApiService])
  val deviceDao = injector.getInstance(classOf[DeviceDao])


//  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")
//"/Users/rinatmoravia/Downloads/test/devices.csv"
  val outputFile = Source

  val source = Source.fromFile(args(0))
  for (line <- source.getLines()) {
    val device = FileLine(line)
    println(device)
  }
//  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")

  //val source = Source.fromFile("/Users/rinatmoravia/Downloads/test/devices.csv")

  source.close()

//  val deviceInfo1 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent33"))
//  val deviceInfo2 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent66"))

  //  device.insertDeviceInfo(deviceInfo1)
  //  device.insertDeviceInfo(deviceInfo2)
  print(deviceDao.getDeviceInfo("userAgent33"))
  System.exit(1)

}

import dao.Device
import entities.DeviceInfo
import com.google.inject.Guice
import services.ApiService

object Main extends App {

  val injector = Guice.createInjector(new Module)
  val apiService = injector.getInstance(classOf[ApiService])
  val device = injector.getInstance(classOf[DeviceDao])


  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")


  val deviceInfo1 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent33"))
  val deviceInfo2 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent66"))

//  device.insertDeviceInfo(deviceInfo1)
//  device.insertDeviceInfo(deviceInfo2)
  print(device.getDeviceInfo("userAgent33"))
  System.exit(1)


}

import dao.Device
import entities.DeviceInfo
import services.ApiService

object Main extends App {

  val apiService = ApiService("12827733d77e0e6e5f54115a34e49da3")

  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")


  val device = new Device

  val deviceInfo1 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent33"))
  val deviceInfo2 = DeviceInfo("dsf", "dfgdfg", "dfg", "code", "url", "name", Some("userAgent66"))

//  device.insertDeviceInfo(deviceInfo1)
//  device.insertDeviceInfo(deviceInfo2)
  print(device.getDeviceInfo("userAgent33"))
  System.exit(1)


}

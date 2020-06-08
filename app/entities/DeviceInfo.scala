package entities

import play.api.libs.json.JsValue

case class DeviceInfo(isMobileDevice: String, deviceType: String,
                      brand: String, brandCode: String, brandUrl: String, name: String, userAgent:Option[String] = None)


object DeviceInfo{
  def apply(json: JsValue): DeviceInfo = {
    val deviceJson = (json \ "device").get
    val isMobileDevice = (deviceJson \ "is_mobile_device").get.toString()
    val deviceType = (deviceJson \ "type").get.toString()
    val brand = (deviceJson \ "brand").get.toString()
    val brandCode = (deviceJson \ "brand_code").get.toString()
    val brandUrl = (deviceJson \ "brand_url").get.toString()
    val name = (deviceJson \ "name").get.toString()
    new DeviceInfo(isMobileDevice, deviceType, brand, brandCode, brandUrl, name)
  }
}

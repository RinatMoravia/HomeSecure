package entities

import play.api.libs.json.{JsLookupResult, JsValue}

case class DeviceInfoDto(isMobileDevice: String, deviceType: String,
                         brand: String, brandCode: String, brandUrl: String, name: String) extends DeviceInfo with Csv {

  override def getFileLine: List[String] = List(isMobileDevice, deviceType, brand, brandCode, brandUrl, name)
}

object DeviceInfoDto{
  def apply(json: JsValue): DeviceInfoDto = {
    val deviceJson = (json \ "device").get
    val isMobileDevice = jsLookupResultToStr(deviceJson \ "is_mobile_device")
    val deviceType = jsLookupResultToStr(deviceJson \ "type")
    val brand = jsLookupResultToStr(deviceJson \ "brand")
    val brandCode = jsLookupResultToStr(deviceJson \ "brand_code")
    val brandUrl = jsLookupResultToStr(deviceJson \ "brand_url")
    val name = jsLookupResultToStr(deviceJson \ "name")
    new DeviceInfoDto(isMobileDevice, deviceType, brand, brandCode, brandUrl, name)
  }

  def apply(deviceInfoEntity: DeviceInfoEntity): DeviceInfoDto =
    new DeviceInfoDto(deviceInfoEntity.isMobileDevice, deviceInfoEntity.deviceType, deviceInfoEntity.brand,
      deviceInfoEntity.brandCode, deviceInfoEntity.brandUrl, deviceInfoEntity.name)

  val csvSchema = List("is_mobile_device", "type", "brand", "brand_code", "brand_url", "name")

  private def jsLookupResultToStr(jsLookUpRes: JsLookupResult) =
    removeRedundancy(jsLookUpRes.get.toString())
  private def removeRedundancy(string: String): String = {
    string.tail.stripSuffix('"'.toString)
  }
}

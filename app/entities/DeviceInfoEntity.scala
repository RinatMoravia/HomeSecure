package entities

case class DeviceInfoEntity(isMobileDevice: String, deviceType: String,
                            brand: String, brandCode: String, brandUrl: String, name: String, userAgent: String) extends DeviceInfo

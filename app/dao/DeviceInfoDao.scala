package dao

import entities.{DeviceInfoDto, DeviceInfoEntity}
import javax.inject.{Inject, Singleton}
import org.jooq.impl.DSL
import org.jooq.{DSLContext, Record, Result}

import scala.jdk.javaapi.CollectionConverters.asScala


trait DeviceInfoDao extends Dao {

  def getDeviceInfo(userAgent: String): Option[DeviceInfoEntity]

  def insertDeviceInfo(userAgent: String, deviceInfo: DeviceInfoDto): Int
}

@Singleton
class DeviceInfoDaoImpl @Inject()(dslContext: DSLContext) extends DeviceInfoDao {

  private val tableName = "Devices"

  def getDeviceInfo(userAgent: String): Option[DeviceInfoEntity] = {
    val devicesInfo = dslContext.selectFrom(tableName)
      .where(DSL.field("user_agent").equal(userAgent))
      .fetch()
    mapper(devicesInfo).headOption
  }

  def insertDeviceInfo(userAgent: String, deviceInfo: DeviceInfoDto): Int =
    dslContext.insertInto(DSL.table(tableName))
      .columns(DSL.field("user_agent"), DSL.field("is_mobile_device"), DSL.field("type"), DSL.field("brand"),
        DSL.field("brand_code"), DSL.field("brand_url"), DSL.field("name"))
      .values(userAgent, deviceInfo.isMobileDevice, deviceInfo.deviceType, deviceInfo.brand,
        deviceInfo.brandCode, deviceInfo.brandUrl, deviceInfo.name)
      .execute()


  private def mapper(res: Result[Record]): Seq[DeviceInfoEntity] = {
    asScala(res.map { r =>
      val userAgent = r.getValue("user_agent").toString
      val isMobileDevice = r.getValue("is_mobile_device").toString
      val deviceType = r.getValue("type").toString
      val brand = r.getValue("brand").toString
      val brandCode = r.getValue("brand_code").toString
      val brandUrl = r.getValue("brand_url").toString
      val name = r.getValue("name").toString
      DeviceInfoEntity(isMobileDevice, deviceType, brand, brandCode, brandUrl, name, userAgent)
    }).toSeq
  }

}


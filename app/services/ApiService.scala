package services

import entities.DeviceInfo
import javax.inject.{Inject, Singleton}
import play.api.libs.ws._

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future

@Singleton
class ApiService @Inject()(wsClient: WSClient)(accessKey: String) {

  def getDevicesDetails(ua: String): Future[DeviceInfo] = {
    val response: Future[WSResponse] = wsClient.url(s"http://api.userstack.com/detect")
      .withQueryStringParameters(("access_key", accessKey), ("ua", ua))
      .get()
    response.map(response => DeviceInfo(response.json))
  }

}

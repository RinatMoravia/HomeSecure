package services

import entities.DeviceInfoDto
import play.api.libs.ws._

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future


class ApiService(wsClient: WSClient, accessKey: String) {

  def getDevicesDetails(ua: String): Future[DeviceInfoDto] = {
    val response: Future[WSResponse] = wsClient.url(s"http://api.userstack.com/detect")
      .withQueryStringParameters(("access_key", accessKey), ("ua", ua))
      .get()
    response.map(response => DeviceInfoDto(response.json))
  }

}

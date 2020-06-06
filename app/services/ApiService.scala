package services

import akka.actor.ActorSystem
import entities.DeviceInfo
import play.api.libs.ws._
import play.api.libs.ws.ahc.AhcWSClient

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future


case class ApiService(accessKey: String)  {
private implicit val system: ActorSystem = ActorSystem()

private val wsClient: AhcWSClient = AhcWSClient()

  def getDevicesDetails(ua: String): Future[DeviceInfo] = {
  val response: Future[WSResponse] = wsClient.url(s"http://api.userstack.com/detect")
    .withQueryStringParameters(("access_key", accessKey), ("ua", ua))
    .get()
    response.map(response => DeviceInfo(response.json))
}

}

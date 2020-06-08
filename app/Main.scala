import services.ApiService

object Main extends App {

val apiService = ApiService("12827733d77e0e6e5f54115a34e49da3")

  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")

}

package src

import services.MergeDeviceDetails

object Main extends App {

  print(args.length)
  if (args.length != 3) {
    println("bad input")
    System.exit(1)
  }

  val conf = Conf(args(0), args(1), args(2))

  val mergeDeviceDetails = MergeDeviceDetails(conf)


  mergeDeviceDetails.initFiles()

  mergeDeviceDetails.MergeFileAndDeviceDetails()

  mergeDeviceDetails.closeFiles()

  System.exit(1)

}

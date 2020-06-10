package src

import java.io.{BufferedWriter, FileWriter}
import java.util

import com.google.inject.Guice
import dao.DeviceDao
import entities.FileLine
import services.ApiService

import scala.jdk.javaapi.CollectionConverters.asJava
import au.com.bytecode.opencsv.CSVWriter

import scala.collection.mutable.ListBuffer


object Main extends App {

//  if (args.length != 1){
//    println("bad input")
//    System.exit(1)
//  }
//  val injector = Guice.createInjector(new Module)
//  val apiService = injector.getInstance(classOf[ApiService])
//  val deviceDao = injector.getInstance(classOf[DeviceDao])


//  apiService.getDevicesDetails("Xbox Live Client/2.0.17511.0")
//"/Users/rinatmoravia/Downloads/test/devices.csv"

  val outputFile = new BufferedWriter(new FileWriter("/Users/rinatmoravia/homesecure.csv"))
  val csvWriter = new CSVWriter(outputFile)
  val csvSchema = Array("id", "name", "age", "city")
  //("id", "name", "age", "city")
  val records =  Array("3000", "rinat", "33", "RoshHaifg")
  var listOfRecords = new ListBuffer[Array[String]]()
  listOfRecords += csvSchema
//  listOfRecords += records

val myStr = "300,fdgfg,dfgf,gggg"
//  csvWriter.writeAll(asJava(listOfRecords))
  csvWriter.writeNext(myStr)
  outputFile.close()







  System.exit(1)

}

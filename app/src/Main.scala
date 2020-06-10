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

  if (args.length != 1){
    println("bad input")
    System.exit(1)
  }



  System.exit(1)

}

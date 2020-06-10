package src

import java.sql.DriverManager

import akka.actor.ActorSystem
import com.google.inject.AbstractModule
import com.typesafe.config.ConfigFactory
import dao.{DeviceInfoDao, DeviceInfoDaoImpl}
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import play.api.libs.ws.WSClient
import play.api.libs.ws.ahc.AhcWSClient


/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `src.Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class Module extends AbstractModule {
  private implicit val system: ActorSystem = ActorSystem()
  private val connection = DriverManager.getConnection("jdbc:sqlite:/Users/rinatmoravia/sqlite/Home_Secure.db")
  private val dslContext = DSL.using(connection, SQLDialect.SQLITE)


  override def configure() = {

    bind(classOf[WSClient]).toInstance(AhcWSClient())
    bind(classOf[DeviceInfoDao]).toInstance(new DeviceInfoDaoImpl(dslContext))

  }

}

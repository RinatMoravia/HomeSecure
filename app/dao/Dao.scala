package dao

import java.sql.DriverManager

import org.jooq.SQLDialect
import org.jooq.impl.DSL

trait Dao {

  private val connection = DriverManager.getConnection("jdbc:sqlite:/Users/rinatmoravia/sqlite/Home_Secure.db")

  protected val dslContext = DSL.using(connection, SQLDialect.SQLITE)

}

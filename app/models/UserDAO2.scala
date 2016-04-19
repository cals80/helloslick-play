package models

import javax.inject.Inject

import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.MySQLDriver
import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
  * Created by carlossouza on 4/18/16.
  */
class UserDAO2 @Inject() (dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[MySQLDriver]

  import slick.driver.MySQLDriver.api._

  def all(): Future[Seq[UserRow]] = dbConfig.db.run(Tables.User.result)

  def findByEmail(email: String): Future[UserRow] = {
    val f = dbConfig.db.run(Tables.User.filter(_.email === email).result.headOption)
    f.map { result => result match {
      case Some(u) => u
      case None => throw new Exception("User not found")
    }}
  }
}

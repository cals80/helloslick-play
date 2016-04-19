package controllers

import javax.inject._
import models._
import play.api._
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import play.api.mvc._
import slick.driver.MySQLDriver
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/*@Singleton
class HomeController @Inject() (dbConfigProvider: DatabaseConfigProvider) extends Controller with Formats {
  val dbConfig = dbConfigProvider.get[MySQLDriver]
  import slick.driver.MySQLDriver.api._

  def all(): Future[Seq[UserRow]] = dbConfig.db.run(Tables.User.result)

  def index = Action.async {
    all().map { result => Ok(Json.toJson(result)) }
  }
}*/
@Singleton
class HomeController @Inject() (userDAO: UserDAO2) extends Controller with Formats {
  def index = Action.async {
    userDAO.all().map { result => Ok(Json.toJson(result)) }
  }
}
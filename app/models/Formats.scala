package models

import java.sql.Timestamp
import play.api.libs.functional.syntax._
import play.api.libs.json._

trait Formats {
  implicit val rds: Reads[Timestamp] = (__ \ "time").read[Long].map{ long => new Timestamp(long) }
  implicit val wrs: Writes[Timestamp] = (__ \ "time").write[Long].contramap{ (a: Timestamp) => a.getTime }
  implicit val fmt: Format[Timestamp] = Format(rds, wrs)

  implicit val TokenRowFormat = Json.format[TokenRow]
  implicit val UserRowFormat = Json.format[UserRow]
}
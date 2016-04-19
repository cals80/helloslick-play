package models

case class TokenRow(id: Long, userId: Int, token: String = "", ip: String = "", userAgent: String = "", createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)
case class UserRow(id: Int, name: String, email: String = "", password: String = "", createdAt: java.sql.Timestamp, updatedAt: java.sql.Timestamp)

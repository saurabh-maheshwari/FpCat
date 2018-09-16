package com.heliosmi.fp

sealed trait Json
final case class JsObject(get: Map[String,Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json

trait JsonWriter[A] {
  def write(value: A): Json
}

final case class Person(name: String, email: String)

object JsonWriterInstances {

 implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
   override def write(value: String): Json = JsString(value)
 }
}

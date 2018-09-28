package com.heliosmi.fp

import cats.syntax.eq._
import cats.instances.int._
import cats.instances.option._

import java.util.Date
import cats.instances.long._
import cats.instances.string._
import cats.Eq

final case class Cat(name: String, age:Int, color: String)

sealed trait Shape
case class Circle(radius: Double) extends Shape

object EqSyntax{
val result = Option(1) === Option.empty[Int]

implicit val dateEq: Eq[Date] = Eq.instance[Date] {
  (date1, date2) => date1.getTime === date2.getTime
}

val x = new Date()
val y = new Date()

implicit val catEq:Eq[Cat] = Eq.instance[Cat] {
 (cat1, cat2) => cat1.name === cat2.name && cat1.age === cat2.age && cat1. color === cat2.color
}

val cat1 = Cat("Garfield", 38, "orange and black")
val cat2 = Cat("Heathcliff",33, "orange and black")

val circles: List[Circle] = ???
val shapes : List[Shape] = circles
}

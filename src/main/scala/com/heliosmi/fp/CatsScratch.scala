package com.heliosmi.fp

import cats._
import cats.implicits._
import java.util.Date

sealed trait test

object CatsSyntax{

val showInt: Show[Int] = Show.apply[Int]
val showString: Show[String] = Show.apply[String]

val intAsString: String = showInt.show(123)
val stringAsString : String = showString.show("abc")

implicit val dateShow:Show[Date] = Show.show(date => s"${date.getTime}ms since the epoch.")


}

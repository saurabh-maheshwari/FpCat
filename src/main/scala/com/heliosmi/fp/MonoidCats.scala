package com.heliosmi.fp


trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
def empty: A
}

object MonoidCats {
  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean = {
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  }

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean = {
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
  }
}


object AdderExercise{
  import cats.Monoid._
  import cats.syntax.semigroup._
  def add(items: List[Int]):Int = items.fold(0)( _ + _ )

  def add[A](items: List[A])(implicit m: cats.Monoid[A]) : A =
    items.fold(m.empty)( _ |+| _)

  case class Order(totalCost: Double, quantity: Double)

  def monoidOrder = new cats.Monoid[Order]{
     def empty: Order = Order(0,0)

     def combine(x: Order, y: Order): Order = Order(
       x.totalCost + y.totalCost,
       x.quantity + y.quantity
     )

  }
}
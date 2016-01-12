package com.piotrkafel.fpis

object Chapter5 {

  sealed trait Stream[+A] {

    /**
     * Implementation for exercise 5.1
     */
    def toList: List[A] = this match {
      case Empty => List()
      case Cons(h, t) => h()::t().toList
    }

    /**
     * Implementation for exercise 5.2
     */
    def take(n: Int): Stream[A] = this match {
      case Empty => Stream.empty
      case Cons(h, t) => if(n > 0) Stream.cons(h(), t().take(n-1))
                         else Stream.empty
    }

    /**
     * Implementation for exercise 5.3
     */
    def drop(n: Int): Stream[A] = this match {
      case Empty => Stream.empty
      case Cons(h, t) => if(n > 0) t().drop(n-1)
                         else t()
    }
  }

  case object Empty extends Stream[Nothing]
  case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  object Stream {

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }

    def empty[A]: Stream[A] = Empty

    def apply[A](as: A*): Stream[A] =
      if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }
}

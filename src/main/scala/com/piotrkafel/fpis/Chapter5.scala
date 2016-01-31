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
     * Implementation for exercise 5.2
     */
    def drop(n: Int): Stream[A] = this match {
      case Empty => Stream.empty
      case Cons(h, t) => if(n > 0) t().drop(n-1)
                         else this
    }

    /**
     * Implementation for exercise 5.3
     */
    def takeWhile(p: A => Boolean): Stream[A] = this match {
      case Empty => Stream.empty
      case Cons(h, t) => if(p(h())) Stream.cons(h(), t().takeWhile(p))
                         else Stream.empty
    }

    def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }

    def exists(p: A => Boolean): Boolean = foldRight(false)((a, b) => p(a) || b)

    /**
     * Implementation for exercise 5.4
     */
    def forAll(p: A => Boolean): Boolean = foldRight(true)((a, b) => p(a) && b)

    /**
     * Implementation for exercise 5.5
     */
    def takeWhileByFoldRight(p: A => Boolean): Stream[A] = foldRight(Stream.empty[A])((a,b) => if(p(a)) Stream.cons(a, b) else b)

    /**
     * Implementation for exercise 5.6
     */
    def headOption: Option[A] = foldRight(Option.empty[A])((a,b) => Option.apply(a))

    /**
     * Implementation for exercise 5.7
     */
    def map[B](f: A => B): Stream[B] = foldRight(Stream.empty[B])((a,b) => Stream.cons(f(a), b))

    /**
     * Implementation for exercise 5.7
     */
    def filter(f: A => Boolean): Stream[A] = foldRight(Stream.empty[A])((a,b) => if(f(a)) Stream.cons(a, b) else b.filter(f))

    /**
     * Implementation for exercise 5.7
     */
    def append[B>:A](s: => Stream[B]): Stream[B] = foldRight(s)((a,b) => Stream.cons(a,b))

    /**
     * Implementation for exercise 5.7
     */
    def flatMap[B](f: A => Stream[B]): Stream[B] = foldRight(Stream.empty[B])((a,b) => f(a).append(b))
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

    /**
     * Implementation for exercise 5.8
     */
    def constant[A](a: A): Stream[A] = cons(a, constant(a))

    /**
     * Implementation for exercise 5.9
     */
    def from(n: Int): Stream[Int] = cons(n, from(n + 1))
  }
}

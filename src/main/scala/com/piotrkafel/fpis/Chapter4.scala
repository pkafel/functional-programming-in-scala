package com.piotrkafel.fpis

object Chapter4 {

  sealed trait MyOption[+A] {
    def map[B](f: A => B): MyOption[B] = this match {
      case MySome(v) => MySome(f(v))
      case MyNone => MyNone
    }

    def flatMap[B](f: A => MyOption[B]): MyOption[B] = map(f).getOrElse(MyNone)

    def getOrElse[B >: A](default: => B): B = this match {
      case MySome(v) => v
      case MyNone => default
    }

    def orElse[B >: A](ob: => MyOption[B]): MyOption[B] = map(v => MySome(v)).getOrElse(ob)

    def filter(f: A => Boolean): MyOption[A] = if(map(f).getOrElse(false)) this else MyNone
  }

  case class MySome[+A](value: A) extends MyOption[A]

  case object MyNone extends MyOption[Nothing]
}

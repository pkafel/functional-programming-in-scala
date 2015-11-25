package com.piotrkafel.fpis

import java.lang.Math.pow

object Chapter4 {

  /**
   * Implementation for exercise 4.1
   */
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

  /**
   * Implementation for exercise 4.2
   */
  def variance(xs: Seq[Double]): MyOption[Double] = {

    def mean(xs: Seq[Double]): MyOption[Double] = {
      if(xs.isEmpty) return MyNone
      else MySome(xs.sum / xs.length);
    }

    mean(xs)
      .flatMap(x => MySome(xs.map(v => pow(v - x, 2)).reduce((v1, v2) => v1 + v2)))
      .map(v => v / xs.length)
  }

  /**
   * Implementation for exercise 4.3
   */
  def map2[A,B,C](a: MyOption[A], b: MyOption[B])(f: (A, B) => C): MyOption[C] =
    a.flatMap(aValue =>
      b.map(bValue => f(aValue,bValue)))
}
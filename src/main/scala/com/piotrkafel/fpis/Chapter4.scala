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
      if(xs.isEmpty) MyNone
      else MySome(xs.sum / xs.length)
    }

    mean(xs)
      .flatMap(x => MySome(xs.map(v => pow(v - x, 2)).sum))
      .map(v => v / xs.length)
  }

  /**
   * Implementation for exercise 4.3
   */
  def map2[A,B,C](a: MyOption[A], b: MyOption[B])(f: (A, B) => C): MyOption[C] =
    a.flatMap(aValue =>
      b.map(bValue => f(aValue,bValue)))

  /**
   * Implementation for exercise 4.4
   */
  def sequenceEither[A](a: List[MyOption[A]]): MyOption[List[A]] =
    a.foldRight[MyOption[List[A]]] (MySome(List[A]())) ((elem, result) => map2(elem, result) ((e,r) => e::r))

  /**
   * Implementation for exercise 4.5
   */
  def traverse[A, B](a: List[A])(f: A => MyOption[B]): MyOption[List[B]] =
    a.foldRight[MyOption[List[B]]] (MySome(List[B]())) ((elem, result) => map2(f(elem), result) ((e,r) => e::r))

  /**
   * Implementation for exercise 4.5
   */
  def sequenceByTraverse[A](a: List[MyOption[A]]): MyOption[List[A]] = traverse(a)(e => e)

  /**
   * Implementation for exercise 4.6
   */
  sealed trait MyEither[+E,+A] {

    def map[B](f: A => B): MyEither[E, B] = this match {
      case MyLeft(e) => MyLeft(e)
      case MyRight(a) => MyRight(f(a))
    }

    def flatMap[EE >: E, B](f: A => MyEither[EE, B]): MyEither[EE, B] = this match {
      case MyLeft(e) => MyLeft(e)
      case MyRight(a) => f(a)
    }

    def orElse[EE >: E,B >: A](b: => MyEither[EE, B]): MyEither[EE, B] = this match {
      case MyLeft(e) => b
      case MyRight(a) => this
    }

    def map2[EE >: E, B, C](b: MyEither[EE, B])(f: (A, B) => C): MyEither[EE, C] =
      flatMap(v => b.map(vv => f(v, vv)))
  }

  case class MyLeft[+E](value: E) extends MyEither[E, Nothing]
  case class MyRight[+A](value: A) extends MyEither[Nothing, A]

  /**
   * Implementation for exercise 4.7
   */
  def traverseEither[E, A, B](as: List[A])(f: A => MyEither[E, B]): MyEither[E, List[B]] = {
    as.foldRight[MyEither[E, List[B]]] (MyRight(List[B]())) ((elem, result) => f(elem).map2(result)((e,r) => e::r) )
  }

  /**
   * Implementation for exercise 4.7
   */
  def sequence[E, A](es: List[MyEither[E, A]]): MyEither[E, List[A]] = traverseEither(es)(e => e)
}

package com.piotrkafel.fpis

import scala.annotation.tailrec

object Chapter3 {

  /**
   * Implementation for exercise 3.2
   */
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case x::xs => xs
  }

  /**
   * Implementation for exercise 3.3
   */
  def setHead[A](elem: A,l: List[A]): List[A] = l match {
    case Nil => List(elem)
    case x::xs => elem::xs
  }

  /**
   * Implementation for exercise 3.4
   */
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case _::xs => if(n == 0) l
                  else drop(xs, n-1)
  }

  /**
   * Implementation for exercise 3.5
   */
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case x::xs => if(f(x)) dropWhile(xs)(f)
                  else l
  }

  /**
   * Implementation for exercise 3.6
   */
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case x::Nil => Nil
    case x::xs => x::init(xs)
  }

  /**
   * Implementation for exercise 3.9
   */
  def foldRightLength[A](l: List[A]): Int = l.foldRight(0)((_, y) => y + 1)

  /**
   * Implementation for exercise 3.10
   */
  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
      case Nil => z
      case x::xs => foldLeft(xs, f(z, x)) (f)
  }

  /**
   * Implementation for exercise 3.11
   */
  def sum(l: List[Int]): Int = foldLeft(l, 0)((x, y) => x + y)

  /**
   * Implementation for exercise 3.11
   */
  def product(l: List[Int]): Int = foldLeft(l, 1)((x, y) => x * y)

  /**
   * Implementation for exercise 3.11
   */
  def foldLeftLength[A](l: List[A]): Int = foldLeft(l, 0)((x, _) => x + 1)

  /**
   * Implementation for exercise 3.12
   */
  def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((x, y) => y::x)

  /**
   * Implementation for exercise 3.13
   */
  def foldLeftByFoldRight[A,B](l: List[A], b: B)(f: (B, A) => B): B = l.foldRight((bb: B) => bb)((x,y) => z => y(f(z, x)))(b)

  /**
   * Implementation for exercise 3.13
   */
  def foldRightByFoldLeft[A,B](l: List[A], b: B)(f: (A, B) => B): B = foldLeft(reverse(l), b)((x, y) => f(y, x))

  /**
   * Implementation for exercise 3.14
   */
  def append[A](l1: List[A], l2: List[A]): List[A] = l1.foldRight(l2)((x,y) => x::y)
}

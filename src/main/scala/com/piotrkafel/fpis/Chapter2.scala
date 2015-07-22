package com.piotrkafel.fpis

import scala.annotation.tailrec

object Chapter2 {

  /**
   * Implementation for exercise 2.1
   */
  def fib(n: Int): Int = {
    @tailrec
    def fibInternal(i: Int, prev: Int, current: Int): Int =
      if(i == 0) prev
      else fibInternal(i - 1, current, prev + current)

    fibInternal(n, 0, 1)
  }

  /**
   * Implementation for exercise 2.2
   */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(i: Int): Boolean = {
      if(i+1 >= as.length) true
      else if(ordered(as(i), as(i+1))) loop(i+1)
      else false
    }

    loop(0)
  }

  /**
   * Implementation for exercise 2.3
   */
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) =>
      (b: B) =>
        f(a, b)

  /**
   * Implementation for exercise 2.4
   */
  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  /**
   * Implementation for exercise 2.5
   */
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
}

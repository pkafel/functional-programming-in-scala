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
    def loop(i: Int): Boolean = {
      if(i+1 >= as.length) true
      else if(ordered(as(i), as(i+1))) loop(i+1)
      else false
    }

    loop(0)
  }
}

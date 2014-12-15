package chapter2

import scala.annotation.tailrec

object Fibonacci {

  def fib(n: Int): Int = {
    @tailrec
    def fibInternal(i: Int, prev: Int, current: Int): Int =
      if(i == 0) prev
      else fibInternal(i - 1, current, prev + current)

    fibInternal(n, 0, 1)
  }
}


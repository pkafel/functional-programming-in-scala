package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter2.fib
import org.scalatest.FlatSpec

class FibonacciTest extends FlatSpec {

  "Fib function" should "return correct Fibonacci numbers" in {
    assert(fib(0) == 0)
    assert(fib(1) == 1)
    assert(fib(11) == 89)
    assert(fib(19) == 4181)
  }
}

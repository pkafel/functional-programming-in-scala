package chapter2

import org.scalatest.FlatSpec


class FibonacciTest extends FlatSpec {

  "Fib function" should "return correct Fibonacci numbers" in {
    assert(Fibonacci.fib(0) == 0)
    assert(Fibonacci.fib(1) == 1)
    assert(Fibonacci.fib(11) == 89)
    assert(Fibonacci.fib(19) == 4181)
  }
}

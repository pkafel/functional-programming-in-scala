package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class FibTest extends FlatSpec {

  "Stream.fib function" should "return stream of Fibonacci numbers" in {
    assert(Stream.fib.take(8).toList == List(0,1,1,2,3,5,8,13))
  }
}

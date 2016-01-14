package com.piotrkafel.fpis.chapter5

import org.scalatest.FlatSpec

class TakeWhileTest extends FlatSpec {

  "Stream.takeWhile function" should "return stream of first elements that match given predicate" in {
    assert(Stream.apply(1,3,5,7,9).takeWhile(_ < 6) == Stream.apply(1,3,5))
  }

  "Stream.takeWhile function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty[Int].takeWhile(_ < 6) == Stream.empty)
  }
}

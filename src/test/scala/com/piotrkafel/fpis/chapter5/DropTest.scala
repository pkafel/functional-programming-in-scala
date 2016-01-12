package com.piotrkafel.fpis.chapter5

import org.scalatest.FlatSpec

class DropTest extends FlatSpec {

  "Stream.drop function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty.drop(5) == Stream.empty)
  }

  "Stream.drop function" should "return last n elements of stream" in {
    assert(Stream.apply(1,3,5,7).drop(2) == Stream.apply(5,7))
  }

  "Stream.drop function" should "return empty stream if n bigger than number of elements in stream" in {
    assert(Stream.apply(1,3).drop(7) == Stream.empty)
  }
}

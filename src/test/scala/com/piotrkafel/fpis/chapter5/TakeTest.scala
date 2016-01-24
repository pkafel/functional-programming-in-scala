package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class TakeTest extends FlatSpec {

  "Stream.take function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty.take(5) == Stream.empty)
  }

  "Stream.take function" should "return first n elements of stream" in {
    assert(Stream.apply(1,3,5,7).take(2).toList == List(1,3))
  }

  "Stream.take function" should "return whole stream if n bigger than number of elements in stream" in {
    assert(Stream.apply(1,3).take(7).toList == List(1,3))
  }
}

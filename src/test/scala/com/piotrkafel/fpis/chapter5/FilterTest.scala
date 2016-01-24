package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class FilterTest extends FlatSpec {

  "Stream.filter function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty[Int].filter(_ < 5) == Stream.empty)
  }

  "Stream.filter function" should "return stream filtered elements" in {
    assert(Stream.apply(1,3,5,7,9,1).filter(_ < 5).toList == List(1,3,1))
  }
}

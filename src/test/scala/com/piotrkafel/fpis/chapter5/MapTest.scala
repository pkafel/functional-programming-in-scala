package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class MapTest extends FlatSpec {

  "Stream.map function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty[Int].map(_ * 2) == Stream.empty)
  }

  "Stream.map function" should "return stream with transformed elements" in {
    assert(Stream.apply(1,3,5).map(_ * 2).toList == List(2,6,10))
  }
}

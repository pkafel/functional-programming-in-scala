package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class FlatMapTest extends FlatSpec {

  "Stream.flatMap function" should "return empty stream when called on empty stream" in {
    assert(Stream.empty[Int].flatMap(x => Stream.apply(x,x,x)) == Stream.empty)
  }

  "Stream.flatMap function" should "return stream with transformed elements" in {
    assert(Stream.apply(1,3,5).flatMap(x => Stream.apply(x,x,x)).toList == List(1,1,1,3,3,3,5,5,5))
  }
}

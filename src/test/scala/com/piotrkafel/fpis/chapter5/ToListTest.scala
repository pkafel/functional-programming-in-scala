package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class ToListTest extends FlatSpec {

  "Stream.toList function" should "return empty list for empty stream" in {
    assert(Stream.empty.toList == List())
  }

  "Stream.toList function" should "return list for non-empty stream" in {
    assert(Stream.apply(1,3,5).toList == List(1,3,5))
  }
}

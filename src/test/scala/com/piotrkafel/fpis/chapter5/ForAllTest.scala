package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class ForAllTest extends FlatSpec {

  "Stream.forAll function" should "return true if all elements match predicate" in {
    assert(Stream.apply(1,3).forAll(_ < 5))
  }

  "Stream.forAll function" should "return false if at least one element doesnt match predicate" in {
    assert(!Stream.apply(1,3,5).forAll(_ < 5))
  }

  "Stream.forAll function" should "return true for empty stream" in {
    assert(Stream.empty[Int].forAll(_ < 5))
  }
}

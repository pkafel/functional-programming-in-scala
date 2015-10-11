package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class MaximumTest extends FlatSpec {

  "maximum function" should "return value of leaf when one element tree" in {
    assert(maximum(Leaf(2)) == 2)
  }

  "maximum function" should "return maximum from tree" in {
    assert(maximum(Branch(Branch(Leaf(1), Leaf(2)), Leaf(11))) == 11)
  }
}

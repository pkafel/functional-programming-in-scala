package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class DepthTest extends FlatSpec {

  "depth function" should "return one for leaf" in {
    assert(depth(Leaf(22)) == 1)
  }

  "depth function" should "should return depth of tree" in {
    assert(depth(Branch(Branch(Leaf(1), Leaf(2)), Leaf(11))) == 3)
  }
}

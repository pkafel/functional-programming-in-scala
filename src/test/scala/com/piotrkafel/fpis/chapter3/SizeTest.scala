package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class SizeTest extends FlatSpec {

  "size function" should " should return 1 for leaf" in {
    assert(size(Leaf(1)) == 1)
  }

  "size function" should " should return number of nodes in a tree" in {
    assert(size(Branch(Branch(Leaf(1), Leaf(2)), Leaf(11))) == 5)
  }
}

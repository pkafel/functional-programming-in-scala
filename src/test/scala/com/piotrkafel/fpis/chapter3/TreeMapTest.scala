package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class TreeMapTest extends FlatSpec {

  "treeMap function" should "new instance of leaf with modified value" in {
    assert(treeMap(Leaf(4))(_ * 2) == Leaf(8))
  }

  "treeMap function" should "new instance of tree with modified value" in {
    assert(treeMap(Branch(Branch(Leaf(1), Leaf(2)), Leaf(11)))(_ * 2) == Branch(Branch(Leaf(2), Leaf(4)), Leaf(22)))
  }
}

package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4._
import org.scalatest.FlatSpec

class SequenceTest extends FlatSpec {

  "sequence function" should "return Left if at least one element on the list is MyLeft" in {
    assert(sequence(List(MyRight(32), MyLeft("wow"), MyRight(33))) == MyLeft("wow"))
  }

  "sequence function" should "return Right if there is no MyLeft on the list" in {
    assert(sequence(List(MyRight(32), MyRight(33))) == MyRight(List(32, 33)))
  }
}

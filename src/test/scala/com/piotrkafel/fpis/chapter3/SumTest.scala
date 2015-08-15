package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class SumTest extends FlatSpec {

  "sum function" should " should return 0 for empty list" in {
    assert(sum(Nil) == 0)
  }

  "sum function" should " should return sum of the elements on the list" in {
    assert(sum(List(1,2,3)) == 6)
  }
}

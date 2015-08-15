package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class LengthTest extends FlatSpec {

  "length function" should "return 0 for empty list" in {
    assert(foldRightLength(Nil) == 0)
    assert(foldLeftLength(Nil) == 0)
  }

  "length function" should "return length of list" in {
    assert(foldRightLength(List(1,2,3)) == 3)
    assert(foldLeftLength(List(1,2,3)) == 3)
  }
}

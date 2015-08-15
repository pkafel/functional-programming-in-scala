package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class LengthTest extends FlatSpec {

  "length function" should "return 0 for empty list" in {
    assert(length(Nil) == 0)
  }

  "length function" should "return length of list" in {
    assert(length(List(1,2,3)) == 3)
  }
}

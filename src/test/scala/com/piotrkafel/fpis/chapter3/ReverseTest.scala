package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class ReverseTest extends FlatSpec {

  "reverse function" should " should return empty list when reverse empty list" in {
    assert(reverse(Nil) == Nil)
  }

  "reverse function" should " should reverse list" in {
    assert(reverse(List(1,2,3,4,5,6)) == List(6,5,4,3,2,1))
  }
}

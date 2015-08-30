package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class AddOneTest extends FlatSpec {

  "addOne function" should "return empty list for empty input list" in {
    assert(addOne(List()) == List())
  }

  "addOne function" should "return list with elements incremented by 1" in {
    assert(addOne(List(1,2,3)) == List(2,3,4))
  }
}

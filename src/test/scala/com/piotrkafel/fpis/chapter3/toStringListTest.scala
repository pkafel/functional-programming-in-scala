package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class ToStringListTest extends FlatSpec {

  "toStringList function" should "return empty list for empty input list" in {
    assert(toStringList(List()) == List())
  }

  "toStringList function" should "return list with strings" in {
    assert(toStringList(List(1,2,3)) == List("1.0","2.0","3.0"))
  }
}

package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class AppendTest extends FlatSpec {

  "append function" should "return empty list when both list are empty" in {
    assert(append(Nil, Nil) == Nil)
  }

  "append function" should "return first list as a result in case of empty second list" in {
    assert(append(List(1,2,3), List()) == List(1,2,3))
  }

  "append function" should "return second list as a result in case of empty first list" in {
    assert(append(List(), List(1,2,3)) == List(1,2,3))
  }

  "append function" should "should return concatenated list" in {
    assert(append(List(1,2,3), List(4,5)) == List(1,2,3,4,5))
  }
}

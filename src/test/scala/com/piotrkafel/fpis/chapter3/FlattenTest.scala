package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class FlattenTest extends FlatSpec {

  "flatten function" should "should return empty list for empty input list" in {
    assert(flatten(List()) == List())
  }

  "flatten function" should "should return empty list for list that contains only empty lists" in {
    assert(flatten(List(Nil, Nil, Nil)) == List())
  }

  "flatten function" should "should return flattened list" in {
    assert(flatten(List(List(1,2),List(3),List(4,5,6))) == List(1,2,3,4,5,6))
  }
}

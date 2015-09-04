package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class FlatMapTest extends FlatSpec {

  "flatMap function" should "should return empty list for empty input list" in {
    assert(flatMap(List())(x => List()) == List())
  }

  "flatMap function" should "should return empty list for list that contains only empty lists" in {
    assert(flatMap(List(1, 2, 3))(x => List(x,x)) == List(1,1,2,2,3,3))
  }
}

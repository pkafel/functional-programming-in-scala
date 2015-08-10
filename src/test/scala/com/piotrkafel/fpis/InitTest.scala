package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class InitTest extends FlatSpec {

  "init function" should "should return empty list for empty list" in {
    assert(init(Nil) == Nil)
  }

  "init function" should "should return empty list for one element list" in {
    assert(init(List(1)) == Nil)
  }

  "init function" should "should return list without last element for list with more then one element" in {
    assert(init(List(1,2,3,4)) == List(1,2,3))
  }
}

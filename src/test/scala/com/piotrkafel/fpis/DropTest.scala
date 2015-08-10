package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class DropTest extends FlatSpec{

  "drop function" should "remove first n elements" in {
    assert(drop(List(1,2,3,4,5), 2) == List(3,4,5))
  }

  "drop function" should "should return empty list when empty list" in {
    assert(drop(List(), 2) == List())
  }

  "drop function" should "should return empty list when number of elements to remove is bigger then list length" in {
    assert(drop(List(1,2), 3) == List())
  }
}

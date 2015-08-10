package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class TailTest extends FlatSpec {

  "tail function" should "return tail of list" in {
    assert(tail(List(1,2,3)) == List(2,3))
  }

  "tail function" should "return empty list for empty list" in {
    assert(tail(List()) == List())
  }
}

package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class SetHeadTest extends FlatSpec {

  "setHead function" should "replace first element of list" in {
    assert(setHead(4, List(1,2,3)) == List(4,2,3))
  }

  "setHead function" should "put element inside empty list" in {
    assert(setHead(4, List()) == List(4))
  }
}

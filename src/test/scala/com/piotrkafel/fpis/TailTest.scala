package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter3.{setHead, tail}
import org.scalatest.FlatSpec

class TailTest extends FlatSpec {

  "tail function" should "return tail of list" in {
    assert(tail(List(1,2,3)) == List(2,3))
  }

  "tail function" should "return empty list for empty list" in {
    assert(tail(List()) == List())
  }

  "setHead function" should "replace first element of list" in {
    assert(setHead(4, List(1,2,3)) == List(4,2,3))
  }

  "setHead function" should "put element inside empty list" in {
    assert(setHead(4, List()) == List(4))
  }
}

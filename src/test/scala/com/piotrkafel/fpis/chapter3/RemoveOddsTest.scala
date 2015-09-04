package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class RemoveOddsTest extends FlatSpec {

  "removeOdds function" should " should return empty list for empty input list" in {
    assert(removeOdds(Nil) == Nil)
  }

  "removeOdds function" should " should return list without odd numbers" in {
    assert(removeOdds(List(1,2,3,4,5,6,7,8,9,10)) == List(2,4,6,8,10))
  }
}

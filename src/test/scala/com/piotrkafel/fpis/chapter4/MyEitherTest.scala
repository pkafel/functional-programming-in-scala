package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4._
import org.scalatest.FlatSpec

class MyEitherTest extends FlatSpec {

  "Either map function" should "return value when called on Right" in {
    assert(MyRight(21).map(v => v * 2) == MyRight(42))
  }

  "Either map function" should "return error when called on Left" in {
    assert(MyLeft("Exception").map(v => "Error") == MyLeft("Exception"))
  }

  "Either flatMap function" should "return value when called on Right" in {
    assert(MyRight(21).flatMap(v => MyRight(v * 2)) == MyRight(42))
  }

  "Either flatMap function" should "return default when called on Left" in {
    assert(MyLeft("Exception").flatMap(v => MyRight(22)) == MyLeft("Exception"))
  }

  "Either orElse function" should "return original value when called on Right" in {
    assert(MyRight(21).orElse(MyRight(42)) == MyRight(21))
  }

  "Either orElse function" should "return alternative value when called on Left" in {
    assert(MyLeft(21).orElse(MyRight(42)) == MyRight(42))
  }

  "Either map2 function" should "return Left if base Either is Left" in {
    assert(MyLeft(21).map2(MyRight(42))((x,y) => 63) == MyLeft(21))
  }

  "Either map2 function" should "return Left if argument is Left" in {
    assert(MyRight(21).map2(MyLeft(42))((x,y) => 63) == MyLeft(42))
  }

  "Either map2 function" should "return Left if both arguments are Left" in {
    assert(MyLeft(21).map2(MyLeft(42))((x,y) => 63) == MyLeft(21))
  }

  "Either map2 function" should "return Right if both arguments are Right" in {
    assert(MyRight(21).map2(MyRight(42))((x,y) => 63) == MyRight(63))
  }
}

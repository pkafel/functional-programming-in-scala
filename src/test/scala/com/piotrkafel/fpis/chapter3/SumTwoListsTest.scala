package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class SumTwoListsTest extends FlatSpec {

  "sumTwoLists function" should " should return empty list for empty input lists" in {
    assert(sumTwoLists(Nil, Nil) == Nil)
  }

  "sumTwoLists function" should " should return first list if second is empty" in {
    assert(sumTwoLists(List(1,2,3), Nil) == List(1,2,3))
  }

  "sumTwoLists function" should " should return second list if first is empty" in {
    assert(sumTwoLists(Nil, List(1,2,3)) == List(1,2,3))
  }

  "sumTwoLists function" should " should return summed elements of two lists of the same length" in {
    assert(sumTwoLists(List(9,8,7), List(1,2,3)) == List(10,10,10))
  }

  "sumTwoLists function" should " should return summed elements of two lists of the different length" in {
    assert(sumTwoLists(List(9,8,7,6,5), List(1,2,3)) == List(10,10,10,6,5))
  }
}

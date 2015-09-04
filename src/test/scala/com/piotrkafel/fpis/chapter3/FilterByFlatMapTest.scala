package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class FilterByFlatMapTest extends FlatSpec {

  "filterByFlatMap function" should " should return empty list for empty input list" in {
    assert(filterByFlatMap(List[Int]())(x => x%2 == 0) == Nil)
  }

  "filterByFlatMap function" should " should return list without odd numbers when passed proper function" in {
    assert(filterByFlatMap(List(1,2,3,4,5,6,7,8,9,10))(x => x%2 == 0) == List(2,4,6,8,10))
  }
}

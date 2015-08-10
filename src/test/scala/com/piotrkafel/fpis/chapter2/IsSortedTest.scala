package com.piotrkafel.fpis.chapter2

import com.piotrkafel.fpis.Chapter2.isSorted
import org.scalatest.FlatSpec

class IsSortedTest extends FlatSpec {

  "isSorted function" should "return information if array is sorted" in {
    assert(isSorted(Array(), (x: Int, y:Int) => x < y) == true)
    assert(isSorted(Array(1), (x: Int, y:Int) => x < y) == true)
    assert(isSorted(Array(1,2,3,4), (x: Int, y:Int) => x < y) == true)
    assert(isSorted(Array(1,2,5,4), (x: Int, y:Int) => x < y) == false)
    assert(isSorted(Array('a','b','c','d'), (x: Char, y:Char) => x < y) == true)
    assert(isSorted(Array('e','b','c','d'), (x: Char, y:Char) => x < y) == false)
    assert(isSorted(Array("apple","banana","watermelon"), (x: String, y:String) => x.compareTo(y) <= 0) == true)
    assert(isSorted(Array("apple","watermelon","banana"), (x: String, y:String) => x.compareTo(y) <= 0) == false)
  }
}

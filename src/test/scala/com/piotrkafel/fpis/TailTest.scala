package com.piotrkafel.fpis

import com.piotrkafel.fpis.Chapter3.{dropWhile, drop, setHead, tail}
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

  "drop function" should "remove first n elements" in {
    assert(drop(List(1,2,3,4,5), 2) == List(3,4,5))
  }

  "drop function" should "should return empty list when empty list" in {
    assert(drop(List(), 2) == List())
  }

  "drop function" should "should return empty list when number of elements to remove is bigger then list length" in {
    assert(drop(List(1,2), 3) == List())
  }

  "dropWhile function" should "should remove prefix elements that match predicate" in {
    assert(dropWhile(List(1,2,3,4,5), (_: Int) < 3) == List(3,4,5))
  }

  "dropWhile function" should "should work with empty list" in {
    assert(dropWhile(List(), (_: Int) < 3) == List())
  }

  "dropWhile function" should "should not remove a single element if first element doesnt match predicate" in {
    assert(dropWhile(List(5,6,7), (_: Int) < 3) == List(5,6,7))
  }
}

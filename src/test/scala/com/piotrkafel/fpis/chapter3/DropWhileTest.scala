package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class DropWhileTest extends FlatSpec {

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

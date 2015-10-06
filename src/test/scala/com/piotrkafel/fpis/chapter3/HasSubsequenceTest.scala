package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class HasSubsequenceTest extends FlatSpec {

  "hasSubsequence function" should "should return false for empty sub list" in {
    assert(!hasSubsequence(List(1,2,3,4,5), Nil))
  }

  "hasSubsequence function" should "should return false for empty sup list" in {
    assert(!hasSubsequence(Nil, List(1,2,3,4,5)))
  }

  "hasSubsequence function" should "should return true if sup list contains sub list" in {
    assert(hasSubsequence(List(1,2,3,4,5), List(2,3)))
  }

  "hasSubsequence function" should "should return false if sup list doesnt contain sub list" in {
    assert(!hasSubsequence(List(1,2,3,4,5), List(2,3,5)))
  }
}


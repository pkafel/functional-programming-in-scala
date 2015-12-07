package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4
import com.piotrkafel.fpis.Chapter4.{MyNone, MySome}
import org.scalatest.FlatSpec

class TraverseTest extends FlatSpec {

  "traverse function" should "return None if after applying function at least one element on the list is None" in {
    assert(Chapter4.traverse(List(32, 11, 33))(e => if (e > 30) MySome(e) else MyNone) == MyNone)
  }

  "traverse function" should "return Some if after applying function there is no None on the list" in {
    assert(Chapter4.traverse(List(32, 33))(e => if (e > 30) MySome(e) else MyNone) == MySome(List(32, 33)))
  }
}

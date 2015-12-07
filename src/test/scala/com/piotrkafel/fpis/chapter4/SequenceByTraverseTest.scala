package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4
import com.piotrkafel.fpis.Chapter4.{MyNone, MySome}
import org.scalatest.FlatSpec

class SequenceByTraverseTest extends FlatSpec {

  "sequenceByTraverse function" should "return None if at least one element on the list is None" in {
    assert(Chapter4.sequenceByTraverse(List(MySome(32), MyNone, MySome(33))) == MyNone)
  }

  "sequenceByTraverse function" should "return Some if there is no None on the list" in {
    assert(Chapter4.sequenceByTraverse(List(MySome(32), MySome(33))) == MySome(List(32, 33)))
  }
}

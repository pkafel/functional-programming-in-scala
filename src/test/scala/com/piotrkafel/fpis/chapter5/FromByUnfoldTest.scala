package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class FromByUnfoldTest extends FlatSpec {

  "Stream.fromByUnfold function" should "return infinite stream of integers" in {
    assert(Stream.fromByUnfold(2).take(3).toList == List(2,3,4))
  }
}

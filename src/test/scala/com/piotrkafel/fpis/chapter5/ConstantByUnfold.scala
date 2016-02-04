package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class ConstantByUnfold extends FlatSpec {

  "Stream.constantByUnfold function" should "return infinite stream" in {
    assert(Stream.constantByUnfold(1).take(3).toList == List(1,1,1))
  }
}

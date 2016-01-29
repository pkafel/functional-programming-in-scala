package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class ConstantTest extends FlatSpec {

  "Stream.constant function" should "return infinite strean" in {
    assert(Stream.constant(1).take(3).toList == List(1,1,1))
  }
}

package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class OnesTest extends FlatSpec {

  "Stream.ones function" should "return infinite stream" in {
    assert(Stream.ones.take(3).toList == List(1,1,1))
  }
}

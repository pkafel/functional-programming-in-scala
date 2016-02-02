package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5.Stream
import org.scalatest.FlatSpec

class UnfoldTest extends FlatSpec {

  "Stream.unfold function" should "return stream of numbers" in {
    assert(Stream.unfold(1)(i => if(i < 3) Some(i, i + 1) else None).take(8).toList == List(1,2))
  }
}

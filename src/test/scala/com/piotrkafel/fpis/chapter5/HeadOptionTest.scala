package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class HeadOptionTest extends FlatSpec {

  "Stream.headOption function" should "return Empty if stream is empty" in {
    assert(Stream.empty.headOption == Option.empty)
  }

  "Stream.headOption function" should "return Option of first element" in {
    assert(Stream.apply(1,3,5).headOption == Option.apply(1))
  }
}

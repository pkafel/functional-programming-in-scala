package com.piotrkafel.fpis.chapter5

import com.piotrkafel.fpis.Chapter5._
import org.scalatest.FlatSpec

class AppendTest extends FlatSpec {

  "Stream.append function" should "return argument of append when done on empty stream" in {
    assert(Stream.empty[Int].append(Stream.apply(1,3,5)).toList == List(1,3,5))
  }

  "Stream.append function" should "return appended stream" in {
    assert(Stream.apply(1,3,5).append(Stream.apply(7,9)).toList == List(1,3,5,7,9))
  }

  "Stream.append function" should "return base stream when append empty stream" in {
    assert(Stream.apply(1,3,5).append(Stream.empty).toList == List(1,3,5))
  }
}

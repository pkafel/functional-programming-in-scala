package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class FoldLeftTest extends FlatSpec {

  "foldLeft function" should "be able to calculate length" in {
    assert(foldLeft(List(1,2,3,4,5,6), 0)((x, _) => x + 1) == 6)
  }
}

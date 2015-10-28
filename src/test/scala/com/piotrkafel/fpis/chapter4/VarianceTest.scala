package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4.{MySome, MyNone, variance}
import org.scalatest.FlatSpec

class VarianceTest extends FlatSpec{

  "variance function" should "return None for empty seq" in {
    assert(variance(List()) == MyNone)
  }

  "variance function" should "return variance for seq" in {
    assert(variance(List(2,5,1,3)) == MySome(2.1875))
  }
}

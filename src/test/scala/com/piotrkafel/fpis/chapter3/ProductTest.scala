package com.piotrkafel.fpis.chapter3

import com.piotrkafel.fpis.Chapter3._
import org.scalatest.FlatSpec

class ProductTest extends FlatSpec {

  "product function" should " should return 1 for empty list" in {
    assert(product(Nil) == 1)
  }

  "product function" should " should return product of the elements on the list" in {
    assert(product(List(1,2,3)) == 6)
  }
}

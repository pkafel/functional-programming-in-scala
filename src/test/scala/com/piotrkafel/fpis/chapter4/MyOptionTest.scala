package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4.MyOption
import com.piotrkafel.fpis.Chapter4.MySome
import com.piotrkafel.fpis.Chapter4.MyNone
import org.scalatest.FlatSpec

class MyOptionTest extends FlatSpec {

  "Option map function" should "return value when called on Some" in {
    assert(MySome(21).map(v => v * 2).getOrElse(1) == 42)
  }

  "Option map function" should "return default when called on None" in {
    assert(getNone.map(v => v * 2).getOrElse(1) == 1)
  }

  "Option flatMap function" should "return value when called on Some" in {
    assert(MySome(21).flatMap(v => MySome(v * 2)).getOrElse(1) == 42)
  }

  "Option flatMap function" should "return default when called on None" in {
    assert(getNone.flatMap[Int](v => MySome(v * 2)).getOrElse(1) == 1)
  }

  "Option orElse function" should "return original value when called on Some" in {
    assert(MySome(21).orElse(MySome(42)).getOrElse(1) == 21)
  }

  "Option orElse function" should "return alternative value when called on None" in {
    assert(getNone.orElse(MySome(42)).getOrElse(1) == 42)
  }

  "Option orElse function" should "return default value when called on None and alternative value is None" in {
    assert(getNone.orElse(MyNone).getOrElse(1) == 1)
  }

  "Option filter function" should "return value when called on Some that match predicate" in {
    assert(MySome(21).filter(_ > 20).getOrElse(1) == 21)
  }

  "Option filter function" should "return default value when called on Some that doesnt match predicate" in {
    assert(MySome(19).filter(_ > 20).getOrElse(1) == 1)
  }

  "Option filter function" should "return default when called on None" in {
    assert(getNone.filter(_ > 20).getOrElse(1) == 1)
  }

  def getNone: MyOption[Int] = MyNone
}

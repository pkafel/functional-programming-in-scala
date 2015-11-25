package com.piotrkafel.fpis.chapter4

import com.piotrkafel.fpis.Chapter4.{MySome, MyOption, MyNone, map2}
import org.scalatest.FlatSpec

class Map2Test extends FlatSpec {

  "map2 function" should "return None if both params are None" in {
    assert(map2(getNone, getNone)((x,y) => x + y) == MyNone)
  }

  "map2 function" should "return None if first param is None" in {
    assert(map2(MySome(42), getNone)((x,y) => x + y) == MyNone)
  }

  "map2 function" should "return None if second param is None" in {
    assert(map2(getNone, MySome(42))((x,y) => x + y) == MyNone)
  }

  "map2 function" should "return Some if both params are Some" in {
    assert(map2(MySome(21), MySome(42))((x,y) => x + y) == MySome(63))
  }

  def getNone: MyOption[Int] = MyNone
}

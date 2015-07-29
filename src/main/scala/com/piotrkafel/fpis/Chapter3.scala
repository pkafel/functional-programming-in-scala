package com.piotrkafel.fpis


object Chapter3 {

  /**
   * Implementation for exercise 3.2
   */
  def tail[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case x::xs => xs
  }
}

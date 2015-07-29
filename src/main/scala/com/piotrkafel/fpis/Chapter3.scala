package com.piotrkafel.fpis


object Chapter3 {

  /**
   * Implementation for exercise 3.2
   */
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case x::xs => xs
  }

  /**
   * Implementation for exercise 3.3
   */
  def setHead[A](elem: A,l: List[A]) = l match {
    case Nil => List(elem)
    case x::xs => elem::xs
  }
}

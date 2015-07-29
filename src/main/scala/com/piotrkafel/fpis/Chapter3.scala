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
  def setHead[A](elem: A,l: List[A]): List[A] = l match {
    case Nil => List(elem)
    case x::xs => elem::xs
  }

  /**
   * Implementation for exercise 3.4
   */
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case _::xs => if(n == 0) l
                  else drop(xs, n-1)
  }

  /**
   * Implementation for exercise 3.5
   */
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case x::xs => if(f(x)) dropWhile(xs, f)
                  else l
  }
}

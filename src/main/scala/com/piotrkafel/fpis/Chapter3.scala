package com.piotrkafel.fpis

import scala.annotation.tailrec

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
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case x::xs => if(f(x)) dropWhile(xs)(f)
                  else l
  }

  /**
   * Implementation for exercise 3.6
   */
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case x::Nil => Nil
    case x::xs => x::init(xs)
  }

  /**
   * Implementation for exercise 3.9
   */
  def foldRightLength[A](l: List[A]): Int = l.foldRight(0)((_, y) => y + 1)

  /**
   * Implementation for exercise 3.10
   */
  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
      case Nil => z
      case x::xs => foldLeft(xs, f(z, x)) (f)
  }

  /**
   * Implementation for exercise 3.11
   */
  def sum(l: List[Int]): Int = foldLeft(l, 0)((x, y) => x + y)

  /**
   * Implementation for exercise 3.11
   */
  def product(l: List[Int]): Int = foldLeft(l, 1)((x, y) => x * y)

  /**
   * Implementation for exercise 3.11
   */
  def foldLeftLength[A](l: List[A]): Int = foldLeft(l, 0)((x, _) => x + 1)

  /**
   * Implementation for exercise 3.12
   */
  def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((x, y) => y::x)

  /**
   * Implementation for exercise 3.13
   */
  def foldLeftByFoldRight[A,B](l: List[A], b: B)(f: (B, A) => B): B = l.foldRight((bb: B) => bb)((x,y) => z => y(f(z, x)))(b)

  /**
   * Implementation for exercise 3.13
   */
  def foldRightByFoldLeft[A,B](l: List[A], b: B)(f: (A, B) => B): B = foldLeft(reverse(l), b)((x, y) => f(y, x))

  /**
   * Implementation for exercise 3.14
   */
  def append[A](l1: List[A], l2: List[A]): List[A] = l1.foldRight(l2)((x,y) => x::y)

  /**
   * Implementation for exercise 3.15
   */
  def flatten[A](l: List[List[A]]): List[A] = l.foldLeft(List[A]())((x,y) => append(x,y))

  /**
   * Implementation for exercise 3.16
   */
  def addOne(l: List[Int]): List[Int] = map(l)(_ + 1)

  /**
   * Implementation for exercise 3.17
   */
  def toStringList(l: List[Double]): List[String] = map(l)(_.toString)

  /**
   * Implementation for exercise 3.18
   */
  def map[A,B](as: List[A])(f: A => B): List[B] = as.foldRight(List[B]())((x,y) => f(x)::y)

  /**
   * Implementation for exercise 3.19
   */
  def filter[A](as: List[A])(f: A => Boolean): List[A] = as.foldRight(List[A]())((x,y) => if (f(x)) x::y else y)

  /**
   * Implementation for exercise 3.19
   */
  def removeOdds(as: List[Int]): List[Int] = filter(as)(x => x%2 == 0)

  /**
   * Implementation for exercise 3.20
   */
  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = flatten(map(as)(f))

  /**
   * Implementation for exercise 3.21
   */
  def filterByFlatMap[A](as: List[A])(f: A => Boolean): List[A] = flatMap(as)((x) => if (f(x)) List(x) else Nil)

  /**
   * Implementation for exercise 3.22
   */
  def sumTwoLists(l1: List[Int], l2: List[Int]): List[Int] = zipWith(l1, l2)((x,y) => x + y)

  /**
   * Implementation for exercise 3.23
   */
  def zipWith[A, B](l1: List[A], l2: List[A])(f: (A, A) => B): List[B] = (l1, l2) match {
    case (x::xs, y::ys) => f(x,y)::zipWith(xs, ys)(f)
    case _ => Nil
  }

  /**
   * Implementation for exercise 3.24
   */
  def hasSubsequence[A](supList: List[A], subList: List[A]): Boolean = {
    def isSubList(sup: List[A], sub: List[A]): Boolean = (sup, sub) match {
      case (x::xs, y::ys) => if(x == y) isSubList(xs, ys) else false
      case (_, Nil) => true
      case _ => false
    }

    (supList, subList) match {
      case (x::xs, y::ys) => if(x == y && isSubList(xs, ys)) true else hasSubsequence(xs, subList)
      case _ => false
    }
  }

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  /**
   * Implementation for exercise 3.25
   */
  def size[A](t: Tree[A]): Int = fold(t) (_ => 1) ((l,r) => l + r + 1)

  /**
   * Implementation for exercise 3.26
   */
  def maximum(t: Tree[Int]): Int = fold(t) (v => v) ((l,r) => l.max(r))

  /**
   * Implementation for exercise 3.27
   */
  def depth[A](t: Tree[A]): Int = fold(t) (_ => 1) ((l,r) => l.max(r) + 1)

  /**
   * Implementation for exercise 3.28
   */
  def treeMap[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold(t) (v => Leaf(f(v)): Tree[B]) ((l,r) => Branch(l, r))

  /**
   * Implementation for exercise 3.29
   */
  def fold[A,B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(v) => f(v)
    case Branch(l,r) => g(fold(l)(f)(g),fold(r)(f)(g))
  }
}

package chapter2


object Sorted {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(i: Int): Boolean = {
      if(i+1 >= as.length) true
      else if(ordered(as(i), as(i+1))) loop(i+1)
      else false
    }

    loop(0)
  }
}

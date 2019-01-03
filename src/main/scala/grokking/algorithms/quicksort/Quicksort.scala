package grokking.algorithms.quicksort

object Quicksort {

  def quicksort(array: Array[Int]): Array[Int] = {
    if (array.length <= 1) {
      array // Base case: arrays with 0 or 1 element are already “sorted.”
    }
    else {
      val pivot = array.head
      val lessThanPivot = array.filter(_ < pivot)
      val greaterThanPivot = array.filter(_ > pivot)
      quicksort(lessThanPivot) ++ Array(pivot) ++ quicksort(greaterThanPivot)
    }
  }
}

package grokking.algorithms.binarysearch

object BinarySearch {

  /**
    * The binary_search function takes a sorted array and an item.
    * If the item is in the array, the function returns its position.
    */
  def binarySearch(sortedArray: Array[String], item: String): Option[Int] = {

    // low and high keep track of which part of the list you’ll search in.
    def search(low: Int, high: Int): Option[Int]  = {
      low <= high match {
        case true =>
          val mid = low + high / 2
          val guess = sortedArray(mid)
          if(guess == item) Some(mid)
          else if(guess > item) search(low, mid - 1) // the guess was to high, so we can use the lower half
          else search(mid + 1, high) // the guess was too low, so we can use the higher half
        case false => None // the item doesn't exits
      }
    }

    search(low = 0,  high = sortedArray.length - 1)
  }

}

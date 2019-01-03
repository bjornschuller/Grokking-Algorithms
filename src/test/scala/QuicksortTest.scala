import grokking.algorithms.quicksort.Quicksort

class QuicksortTest extends TestSpec {

  it should "sort an array using the QuicksortAlgorithm"
    val array = Array(5, 2, 4, 1, 3)
    println("TESTT ARRAY START "+array.toList)
  Quicksort.quicksort(array) shouldBe Array(1,2,3,4,5)
}

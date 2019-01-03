import grokking.algorithms.binarysearch.BinarySearch

class BinarySearchTest extends TestSpec {

  it should "return the correct position based on binary search" in {
    val sortedArrayNames =  Array("Piet", "Klaas", "Henk", "John", "Arnold", "Hendrik", "Bjorn", "Ruud", "Jack", "Evert").sorted
    val item = "Bjorn"

    BinarySearch.binarySearch(sortedArrayNames, item) shouldBe Some(1)
  }
}

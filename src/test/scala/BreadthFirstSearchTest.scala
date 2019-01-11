
import grokking.algorithms.breadthfirstsearch.BreadthFirstSearch

class BreadthFirstSearchTest extends TestSpec {

  it should "find the closest mango seller " in {
    // map a node (key) to all of its neighbors (values)
    val graph: Map[String, List[String]] = Map(
                   "bjorn" -> List("alice", "bob", "claire"),
                    "bob" -> List("anuj", "peggy"),
                    "alice" -> List("peggy"),
                    "claire" -> List("thom", "jonny"),
                    "anuj" -> List.empty,
                    "peggy" -> List.empty,
                    "thom" -> List.empty,
                    "jonny" -> List.empty)



    BreadthFirstSearch.search("bjorn", graph) shouldBe Some("thom")

  }

  it should "not result in an infinite loop " in {
    // map a node (key) to all of its neighbors (values)
    val graph: Map[String, List[String]] = Map(
      "bjorn" -> List("bob"),
      "bob" -> List("bjorn"),
      "alice" -> List("peggy"),
      "claire" -> List("thom", "jonny"),
      "anuj" -> List.empty,
      "peggy" -> List.empty,
      "thom" -> List.empty,
      "jonny" -> List.empty)



    BreadthFirstSearch.search("bjorn", graph) shouldBe None

  }

}

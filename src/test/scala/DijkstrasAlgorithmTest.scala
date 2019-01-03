import grokking.algorithms.dijkstrasalgorithm.DijkstrasAlgorithm
import grokking.algorithms.dijkstrasalgorithm.DijkstrasAlgorithm.{Cost, DirectedEdge}

class DijkstrasAlgorithmTest extends TestSpec {

  behavior of "dijkstra's algorithm"

  /**
    *
    *            3          2
    *           --- Seatle --- Chicago------|
    *          |      |            |        | 4
    *          |      |            |        |
    *     SF --|     1|            | 3      |---NYC
    *          |      |____________|        |
    *          |             |              |
    *           -----------Idaho------------| 6
    *            5
    *
    */
  it should "implement dijkstras algorithm to determine fastest path v1" in {
    val listOfEdges = List(DirectedEdge("SF", "Seatle", 3),
      DirectedEdge("SF", "Idaho", 5),
      DirectedEdge("Idaho", "Seatle", 1),
      DirectedEdge("Idaho", "Chicago", 3),
      DirectedEdge("Seatle", "Chicago", 2),
      DirectedEdge("Seatle", "Idaho", 1),
      DirectedEdge("Chicago", "Idaho", 3),
      DirectedEdge("Chicago", "NYC", 4),
      DirectedEdge("Idaho", "NYC", 6))

    DijkstrasAlgorithm.dijkstra(listOfEdges, "SF", "NYC") shouldBe
      List(Cost("SF",0,"SF"), Cost("Seatle",3,"SF"), Cost("Chicago",5,"Seatle"), Cost("NYC",9,"Chicago"))
  }

  /**
    *
    *            5          4
    *           --->Seatle ---> Chicago---->|
    *          |      ▲ |____     |         | 3
    *          |      |     |     |         |
    *     SF --|     8|     |     | 6       |---> NYC
    *          |      |     |__2__|         |
    *          |      |           ▼         |
    *           ----->Idaho----->NJ-------->| 1
    *            2           7
    *☟
    */
  it should "implement dijkstras algorithm to determine fastest path v2" in {
    val listOfEdges = List(DirectedEdge("SF", "Seatle", 5),
      DirectedEdge("Seatle", "Chicago", 4),
      DirectedEdge("Chicago", "NYC", 3),
      DirectedEdge("Chicago", "NJ", 6),
      DirectedEdge("NJ", "NYC", 1),
      DirectedEdge("SF", "Idaho", 2),
      DirectedEdge("Idaho", "Seatle", 8),
      DirectedEdge("Seatle", "NJ", 2),
      DirectedEdge("Idaho", "NJ", 7))

    DijkstrasAlgorithm.dijkstra(listOfEdges, "SF", "NYC") shouldBe
      List(Cost("SF",0,"SF"), Cost("Seatle",5,"SF"), Cost("NJ",7,"Seatle"), Cost("NYC",8,"NJ"))
  }



}

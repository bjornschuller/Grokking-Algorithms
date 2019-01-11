package grokking.algorithms.dijkstrasalgorithm

import scala.collection.immutable.Queue

object DijkstrasAlgorithm {
  case class DirectedEdge(fromNode: String, toNode: String, cost: Int)
  case class Cost(node: String, accumulatedCost: Int, pathVia: String)
  case class Route(from: String, to: String, cost: Int)

  /**
    * https://www.youtube.com/watch?v=GazC3A4OQTE
    * https://www.youtube.com/watch?v=FSm1zybd0Tk
    *
    * @param graph: stores the neighbors and the costs for getting to that neighbor
    *   - from, to, cost or weight (i.e., also called Edges)
    * @param minPriorityQueue:
    *    will be updated as the algorithm progresses and stores the costs to go to that node from the start.
    *    The queue will be ordered from lowest to highest costs calculated from the start. This is important!
    * @param visitedNodes:
    *    will be updated as the algorithm progresses and stores the shortest costs to go to that node from the start.
    * @return
    *
    */
  private def determineLowestCosts(graph: List[DirectedEdge], minPriorityQueue: Queue[Cost], visitedNodes: Seq[Cost]): Seq[Cost] = {
    if(minPriorityQueue.nonEmpty) {
      val (source, newQueue) = minPriorityQueue.dequeue
      visitedNodes.filter(_.node.contains(source.node)) match {
        case res if res.nonEmpty  =>
         // already visited this node, and since our minimalPriorityQueue is ordered from lowest to highest
         // we can ignore this one, since we know that the one that is visited later will have a higher cost than the one visited earlier
          determineLowestCosts(graph, newQueue, visitedNodes)
        case _ =>
          val neighbors = graph.filter(_.fromNode == source.node)
                               .map(x => Cost(x.toNode, x.cost + source.accumulatedCost, source.node))
          val newMinPriorityQueue = newQueue.enqueue(neighbors).sortBy(_.accumulatedCost)
          val newVisitedNodes = source +: visitedNodes
          determineLowestCosts(graph, newMinPriorityQueue, newVisitedNodes)
      }
    } else {
      visitedNodes
    }
  }

  private def determineShortestPath(target: String, costs: Seq[Cost], path: Seq[Cost]): Seq[Cost] = {
   costs.filter(_.node == target) match {
      case Seq(head) if costs.nonEmpty=>
        determineShortestPath(head.pathVia, costs.filter(_.node != target), head +: path)
      case _ if costs.isEmpty =>
        path
      case Nil => path
      case other => throw new Exception(s"Found more than one route to: $other this should not occur")
    }
  }

  def dijkstra(edges: List[DirectedEdge], source: String, target: String) = {
    edges.find(_.fromNode == source) match {
      case Some(start) =>
        val costs = determineLowestCosts(edges, Queue[Cost]().enqueue(Cost(start.fromNode, 0, start.fromNode)), Seq.empty)
        determineShortestPath(target, costs, Seq.empty)
      case None =>
        throw new Exception(s"Source: $source is unknown")
    }
  }
}

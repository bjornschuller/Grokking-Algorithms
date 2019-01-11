package grokking.algorithms.breadthfirstsearch

import scala.collection.immutable.Queue

object BreadthFirstSearch {

  private def isMangoSeller(name: String): Boolean = name.last == 'm'

  /**
    * find the closest mango seller.
    * step 1: create a queue (FIFO)
    * step 2: add all of your neighbors to the search queue
    * step 3: pop a person of the queue
    * step 4: check if this person is a mango seller
    * step 5: YES -> your done | NO -> add all their neighbors to the search queue and LOOP
    * step 6: If the queue is empty there are no mango sellers in your network
    */
  def search(name: String, graph: Map[String, List[String]]): Option[String] = {

    def doSearch(queue: Queue[String], searched: Array[String]): Option[String] = {
      if(queue.nonEmpty) {
        val (person, newQueue) = queue.dequeue
        isMangoSeller(person) match {
          case true => Some(person)
          case false =>
            graph.get(person) match {
              case Some(friends) if !searched.contains(person) =>
                doSearch(newQueue.enqueue(friends), person +: searched)
              case _ => doSearch(newQueue, person +: searched)
            }
        }
      }
      else None
    }

    graph.get(name) match {
      case Some(friends) => doSearch(Queue[String]().enqueue(friends), Array.empty)
      case None => None
    }
  }
}

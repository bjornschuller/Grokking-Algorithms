package grokking.algorithms.greedy.algorithms

import java.sql.Time

import scala.collection.immutable.TreeMap


object TheClassroomSchedulingProblem {

  case class Class(name: String, startTime: Time, endTime: Time)

  private def soonestEndedClass(classes: Seq[Class]): Class = classes.reduceLeft((x, y) => if(x.endTime.before(y.endTime)) x else y)

  //method also filters out the classes that overlapp
  private def startsAfterThePlannedClassAndEndsSoonest(plannedClass: Class, classes: Seq[Class]): (Class, Seq[Class]) = {
    val startsAfterPlannedClass = classes.filter(r => r.startTime.after(plannedClass.endTime) || r.startTime.equals(plannedClass.endTime))
    (soonestEndedClass(startsAfterPlannedClass), startsAfterPlannedClass)
  }

  def algorithm(classes: Seq[Class]): Map[Int, Class] = {
    def execute(notYetScheduledClasses: Seq[Class], schedule: Map[Int, Class]): Map[Int, Class] = {
      notYetScheduledClasses match {
        case head :: tail  =>
          val mostRecentPlannedClass = schedule.maxBy(_._1)._2
          val (newPlannedClass, newToBePlannedClasses) = startsAfterThePlannedClassAndEndsSoonest(mostRecentPlannedClass, notYetScheduledClasses)
          val newKey = if(schedule.isEmpty) 1 else schedule.keys.max + 1
          execute(newToBePlannedClasses.filter(_.name != newPlannedClass.name), schedule + (newKey -> newPlannedClass))
        case Seq(head) =>
          val newKey = if(schedule.isEmpty) 1 else schedule.keys.max + 1
          execute(Seq.empty, schedule + (newKey -> head))
        case Nil =>
          TreeMap(schedule.toSeq:_*) //sorted map
      }
    }
    execute(classes, Map(1 -> soonestEndedClass(classes)))
  }
}
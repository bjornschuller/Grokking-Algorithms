import java.sql.Time

import grokking.algorithms.greedy.algorithms.TheClassroomSchedulingProblem._
class TheClassroomSchedulingProblemTest extends TestSpec {

  implicit def StringToTime(s: String): Time = Time.valueOf(s)

  it should "use the Classroom Scheduling Problem Algorithm to most effectively use a classroom" in {
    val classes = Seq(
      Class("CS", "10:30:00", "11:30:00"),
      Class("MATH", "10:00:00", "11:00:00"),
      Class("ART", "9:00:00", "10:00:00"),
      Class("MUSIC", "11:00:00", "12:00:00"),
      Class("ENG", "9:30:00", "10:30:00")
    )

    algorithm(classes) shouldBe Map(
      1 -> Class("ART", "9:00:00", "10:00:00"),
      2 -> Class("MATH", "10:00:00", "11:00:00"),
      3 -> Class("MUSIC", "11:00:00", "12:00:00")
    )
  }
}

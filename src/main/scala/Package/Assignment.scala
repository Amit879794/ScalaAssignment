package Package

import java.util.Scanner

object Assignment extends App {

  case class Row(
                  var title: String,
                  var date_published: String,
                  var budget: String,
                  var reviews_from_users: String,
                  var country: String,
                  var genre: String,
                  var duration: String
                )

  val in = new Scanner(System.in)
  val s1 = new Solution1
  println("Enter director name")
  val givenDirector = in.nextLine
  println("Enter Start year for the range")
  val yearStart = in.nextInt
  println("Enter End year for the range")
  val yearEnd = in.nextInt
  s1.solution1(givenDirector, yearStart, yearEnd)

  val s2 = new Solution2
  println("Enter user review")
  val userReview = in.nextInt
  s2.solution2(userReview)

  println("Enter year to find the highest budget titles")
  val givenYear = in.nextInt
  val s3 = new Solution3
  s3.solution3(givenYear)
}

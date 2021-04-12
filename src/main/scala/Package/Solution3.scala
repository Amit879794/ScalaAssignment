package Package

import Package.Assignment.Row

import java.io.{FileNotFoundException, IOException}
import java.util.{InputMismatchException, Scanner}
import scala.collection.mutable.ListBuffer
import scala.io.Source

class Solution3 {
  def solution3(givenYear: Int): String = {
    try {
      val s1 = Source.fromFile("src/main/resources/imdbMovies.csv").getLines().slice(1, 20000).toArray //returns the file data as String
      val ans3 = new ListBuffer[Row]()
      val in = new Scanner(System.in)
      println("3. Generate highest budget titles for the given year and country filters\n")
      s1.foreach { row =>
        val filteredRow = row.replaceAll(",$", ",null")
        val Array(imdb_title_id, title, original_title, year, date_published, genre, duration, country, language, director, writer, production_company, actors, description, avg_vote, votes, budget, usa_gross_income, worlwide_gross_income, metascore, reviews_from_users, reviews_from_critics) =
          filteredRow.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")
        if (s"$year".toInt == givenYear.toInt) {
          ans3.addOne(
            new Row(
              s"$title",
              s"$date_published",
              s"$budget",
              s"$reviews_from_users",
              s"$country",
              s"$genre",
              s"$duration")
          )
        }
      }
      val ans3_ = ans3.maxBy(row => row.budget)

      /**
       * Answers
       */

      print(s"title=${ans3_.title} | ")
      print(s"date_published=${ans3_.date_published} | ")
      print(s"budget=${ans3_.budget} | ")
      print(s"reviews_from_users=${ans3_.reviews_from_users} | ")
      print(s"country=${ans3_.country} | ")
      print(s"genre=${ans3_.genre} | ")
      print(s"duration=${ans3_.duration}")
      println()
      var s = ""
      s += s"title=${ans3_.title} | date_published=${ans3_.date_published} | budget=${ans3_.budget} | " +
        s"reviews_from_users=${ans3_.reviews_from_users} | country=${ans3_.country} | genre=${ans3_.genre} | duration=${ans3_.duration}"
      s
      //      return ans3_

    } catch {
      case ex: FileNotFoundException =>
        println("Missing file exception"); ""

      case ex: IOException =>
        println("Input Output exception"); ""

      case ex: InputMismatchException =>
        println("The input is not of the correct data type"); ""

    }
  }
}


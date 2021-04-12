package Package

import Package.Assignment.Row
import java.io.{FileNotFoundException, IOException}
import java.util.{InputMismatchException, Scanner}
import scala.collection.mutable.ListBuffer
import scala.io.Source

class Solution1 {
  def solution1(givenDirector: String, yearStart: Int, yearEnd: Int): String =  {
    try {
      val s1 = Source.fromFile("src/main/resources/imdbMovies.csv").getLines().slice(1, 20000).toArray //returns the file data as String
      val ans1 = new ListBuffer[Row]()
      println("1. Titles directed by given director in the given year range \n")
      s1.foreach { row =>
        val filteredRow = row.replaceAll(",$", ",null")
        val Array(imdb_title_id, title, original_title, year, date_published, genre, duration, country, language, director, writer, production_company, actors, description, avg_vote, votes, budget, usa_gross_income, worlwide_gross_income, metascore, reviews_from_users, reviews_from_critics) =
          filteredRow.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")
        if ((s"$director" == givenDirector) && (s"$year".toInt >= yearStart.toInt && s"$year".toInt <= yearEnd.toInt)) {
          ans1.addOne(
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

        //2. Generate report of English titles which have user reviews more than given user
        //review filter and sort the report with user reviews by descending
        //      val userReview = 6


        /**
         * Answers
         */


      }
      ans1.foreach { row =>
        print(s"title=${row.title} | ")
        print(s"date_published=${row.date_published} | ")
        print(s"budget=${row.budget} | ")
        print(s"reviews_from_users=${row.reviews_from_users} | ")
        print(s"country=${row.country} | ")
        print(s"genre=${row.genre} | ")
        print(s"duration=${row.duration}")

        println()
      }
      var s = ""
      ans1.foreach { row =>
         s =s + s"title=${row.title} | date_published=${row.date_published} | budget=${row.budget} | reviews_from_users=${row.reviews_from_users} | " +
           s"country=${row.country} | genre=${row.genre} | duration=${row.duration}\n"
      }
      s
    }
    catch {
      case ex: FileNotFoundException =>
        println("Missing file exception"); ""

      case ex: IOException =>
        println("Input Output exception exception"); ""

      case ex: InputMismatchException =>
        println("The input is not of the correct data type"); ""
      //Title, published year, budget, user reviews,country,genre,duration
    }
  }
}

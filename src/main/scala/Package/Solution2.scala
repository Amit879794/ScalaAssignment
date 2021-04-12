package Package

import Package.Assignment.Row
import java.io.{FileNotFoundException, IOException}
import java.util.{InputMismatchException, Scanner}
import scala.collection.mutable.ListBuffer
import scala.io.Source

class Solution2 {
  def solution2(userReview:Int): String = {
    try {
      val s1 = Source.fromFile("src/main/resources/imdbMovies.csv").getLines().slice(1, 20000).toArray //returns the file data as String
      val in = new Scanner(System.in)
      var ans2 = new ListBuffer[Row]()
//      println("Enter user review")
//      val userReview = in.nextInt
      println("2. Generate report of English titles which have user reviews more than given user\n review filter and sort the report with user reviews by descending\n")
      s1.foreach { row =>
        val filteredRow = row.replaceAll(",$", ",null")
        val Array(imdb_title_id, title, original_title, year, date_published, genre, duration, country, language, director, writer, production_company, actors, description, avg_vote, votes, budget, usa_gross_income, worlwide_gross_income, metascore, reviews_from_users, reviews_from_critics) =
          filteredRow.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")
        //2. Generate report of English titles which have user reviews more than given user
        //review filter and sort the report with user reviews by descending
        //      val userReview = 6
        if (s"$reviews_from_users" != "" && s"$reviews_from_users".toInt > userReview) {
          ans2.addOne(
             Row(
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
      ans2 = ans2.sortBy(row => row.reviews_from_users).reverse

      /**
       * Answers
       */
      var s = ""
      ans2.foreach { row =>
        print(s"title=${row.title} | ")
        print(s"date_published=${row.date_published} | ")
        print(s"budget=${row.budget} | ")
        print(s"reviews_from_users=${row.reviews_from_users} | ")
        print(s"country=${row.country} | ")
        print(s"genre=${row.genre} | ")
        print(s"duration=${row.duration}")
        println()
      }
      ans2.foreach { row =>
        s =s + s"title=${row.title} | date_published=${row.date_published} | budget=${row.budget} | reviews_from_users=${row.reviews_from_users} | " +
          s"country=${row.country} | genre=${row.genre} | duration=${row.duration}\n"
      }
//      println(ans2.length)
      s
    }
    catch {
      case ex: FileNotFoundException =>
        println("Missing file exception");""

      case ex: IOException =>
        println("Input Output Exception exception");""

      case ex: InputMismatchException =>
        println("The input is not of the correct data type");""
      //Title, published year, budget, user reviews,country,genre,duration
    }
  }

}


package Package

import scala.io.Source

class ReadCSV {

  def readCSV(): Unit ={
    Source.fromFile("src/main/resources/imdbMovies.csv").getLines().slice(1, 10000).toArray
  }

}

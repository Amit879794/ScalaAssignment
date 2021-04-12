import Package.{Solution1, Solution2, Solution3}
import org.scalatest._

class UnitTest extends FlatSpec {

  it should "Solution1" in {
    val expected1 = "title=Half a Sinner | date_published=1940-04-05 | budget= | reviews_from_users=17 | country=USA | genre=\"Adventure, Comedy, Mystery\" | duration=59\n"
    val s1 = new Solution1
    val actual1 = s1.solution1("Al Christie", 1940, 1943)
    assert(expected1 == actual1, true)
  }

  it should "Solution2" in {
    val expected2 = "title=The Godfather | date_published=1972-08-25 | budget=\"$6,000,000\" | reviews_from_users=3362 | country=USA | genre=\"Crime, Drama\" | duration=175\n"
    val s2 = new Solution2
    val actual2 = s2.solution2(3000)
    assert(expected2 == actual2, true)
  }

  it should "Solution3" in {
    val expected3 = "title=Independenta Romaniei | date_published=1912-09-01 | budget=ROL 400000 | reviews_from_users=3 | country=Romania | genre=\"History, War\" | duration=120"
    val s3 = new Solution3
    val actual3 = s3.solution3(1912)
    assert(expected3 == actual3, true)
  }

}



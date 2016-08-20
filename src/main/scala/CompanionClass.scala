class Connection(
  val host: String, val port: Int,
  private val timeout: Double,
  private[this] val password: String
)

object Connection {
  val conn = new Connection("127.0.0.1", 80, 5.0, "s3cr3t")

  def main(args: Array[String]): Unit = {
    println(conn.host)
    println(conn.timeout)
    //println(conn.password)  // cannot access to private[this] member
  }
}

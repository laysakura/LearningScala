object ControlSyntaxMatch {
  def main(args: Array[String]): Unit = {
    for (_ <- 1 to 1000) {
      val cs = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList
      println(cs match {
        case List(a, b, c, d, f) if a == f => cs
        case List(a, b, c, d, f) => List(a, b, c, d, a)
      })
    }
  }
}

object ErrorHandling {
  def main(args: Array[String]): Unit = {
    val mul = for {
      i2 <- Some(2)
      i3 <- Some(3)
      i5 <- Some(5)
      i7 <- Some(7)
      i11 <- Some(11)
    } yield i2 * i3 * i5 * i7 * i11

    println(mul)
  }
}

// コンパイル通らない...

implicit def upToInt(v: Double): Int = (v + 1.0).toInt

object ImplicitConfusingExample {
  def main(args: Array[String]): Unit = {
    println(3 + 3.1)
  }
}

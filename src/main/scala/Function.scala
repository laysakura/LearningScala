import scala.io.Source

object Function {
  def withFile[A](filename: String)(f: Source => A): A = {
    val s = Source.fromFile(filename)
    try {
      f(s)
    } finally {
      s.close()
    }
  }

  def main(args: Array[String]): Unit = {
    //withFile("/etc/hosts")((s: Source) => for (line <- s.getLines) println(line))

    // {} 使うとRubyのブロックっぽくなる
    withFile("/etc/hosts") { file =>
      for (line <- file.getLines()) println(line)
    }
  }
}

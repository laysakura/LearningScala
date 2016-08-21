trait Showable {  // traitとabstract classの使い分け => https://gist.github.com/gakuzzzz/10081860
  def show: String
}

class ShowablePair[T1 <: Showable, T2 <: Showable](val t1: T1, val t2: T2) extends Showable {
  override def show: String = "(" + t1.show + ", " + t2.show + ")"
}

class Cpu(val gFreq: Float) extends Showable {
  override def show: String = gFreq.toString + " GHz"
}
class Memory(val gSize: Float) extends Showable {
  override def show: String = gSize.toString + " Gbytes"
}

object ShowablePairTest {
  def main(args: Array[String]): Unit = {
    val machine = new ShowablePair(new Cpu(2.7F), new Memory(8.0F))
    println(machine.show)
  }
}

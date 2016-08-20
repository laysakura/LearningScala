trait Stack[+T] {
  def pop: (T, Stack[T])
  def push[E >: T](e: E): Stack[E]
  def isEmpty: Boolean
}

class NonEmptyStack[+T](private val top: T, private val rest: Stack[T]) extends Stack[T] {
  def pop: (T, Stack[T]) = (top, rest)
  def push[E >: T](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def isEmpty: Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def pop: (Nothing, Stack[Nothing]) = throw new IllegalArgumentException("empty stack")
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def isEmpty: Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

object Test {
  def main(args: Array[String]): Unit = {
    val intStack: Stack[Int] = Stack()
    val strStack: Stack[String] = Stack()

    val is1 = intStack.push(1)
    val is2 = is1.push(2)
    val is3 = is2.push(3)
    println(is3.pop)
    println(is2.pop)
    println(is1.pop)
    println(intStack.pop)
  }
}

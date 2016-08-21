object CollectionList {
  def sum(list: List[Int]): Int = list.foldRight(0){(x: Int, y: Int) => x + y}  // x, yの型指定はやや冗長
  def mul(list: List[Int]): Int = list.foldRight(1){(x, y) => x * y}

  def mkString[T](list: List[T])(sep: String): String = list match {
    case Nil => ""
    case x::xs => xs.foldLeft(x.toString){(x, y) => x + sep + y}
  }

  def map[T, U](list: List[T])(f: T => U): List[U] = {
    list.foldLeft(Nil: List[U]){(x, y) => f(y) :: x}.reverse
  }

  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T]) {(x, y) =>
      f(y) match {
        case true => y :: x
        case false => x
      }
    }.reverse
  }

  def count[T](list: List[T])(f: T => Boolean): Int = {
    //list.foldLeft(Nil: List[T]){(x, y) => if (f(y)) y :: x else x}.length // 下のほうがシンプル
    list.foldLeft(0){(x, y) => if (f(y)) x + 1 else x}
  }

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3, 4)))
    println(mul(List(1, 2, 3, 4)))
    println(mkString(List(1, 2, 3, 4))(" :: "))
    println(map(List(1, 2, 3)){x => x*x})
    println(filter(List(1, 2, 3, 4, 5)){x => x % 2 == 1})
    println(count(List(1, 2, 3, 4, 5)){x => x % 2 == 1})
  }
}

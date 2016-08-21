object CollectionArray {
  def swapArray[T](arr: Array[T])(i: Int, j: Int): Unit = {
    val t = arr(i)
    arr(i) = arr(j)
    arr(j) = t
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    swapArray(arr)(2, 4)
    println(arr.mkString(", "))
  }
}

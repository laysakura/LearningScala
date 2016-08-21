sealed abstract class Tree
case class Branch(v: Int, left: Tree, right: Tree) extends Tree
case class Empty() extends Tree

object CaseClassTree {
  def max(root: Tree): Int = root match {
    case Empty() => Int.MinValue
    case Branch(v, l, r) => v max (max(l) max max(r))
  }
  def min(root: Tree): Int = root match {
    case Empty() => Int.MaxValue
    case Branch(v, l, r) => v min (min(l) min min(r))
  }
  def depth(root: Tree): Int = root match {
    case Empty() => 0
    case Branch(v, l, r) => (depth(l) max depth(r)) + 1
  }
  def sort(root: Tree): Tree = root match {
    case Empty() => Empty()
    case Branch(v, Empty(), Empty()) => Branch(v, Empty(), Empty())
    case Branch(v, Branch(lRoot, lLeft, lRight), Empty()) =>
      if (lRoot <= v) Branch(v, Branch(lRoot, lLeft, lRight), Empty())
      else Branch(v, Empty(), Branch(lRoot, lLeft, lRight))
    case Branch(v, Empty(), Branch(rRoot, rLeft, rRight)) =>
      if (v < rRoot) Branch(v, Empty(), Branch(rRoot, rLeft, rRight))
      else Branch(v, Branch(rRoot, rLeft, rRight), Empty())
    case Branch(v, Branch(lRoot, lLeft, lRight), Branch(rRoot, rLeft, rRight)) =>
      if (lRoot <= v && v < rRoot) Branch(v, Branch(lRoot, lLeft, lRight), Branch(rRoot, rLeft, rRight))
      else {
        if (v <= lRoot && lRoot < rRoot) Branch(lRoot, Branch(v, lLeft, lRight), Branch(rRoot, rLeft, rRight))
        else Branch(rRoot, Branch(lRoot, lLeft, lRight), Branch(v, rLeft, rRight))
      }
  }

  def main(args: Array[String]): Unit = {
    // 5 --- 3
    //    |
    //    -- 8 --- 2
    //          |
    //          -- 7 --- 1
    val t = Branch(
      5,
      Branch(
        8,
        Branch(
          7,
          Empty(),
          Branch(1, Empty(), Empty())
        ),
        Branch(2, Empty(), Empty())
      ),
      Branch(3, Empty(), Empty())
    )

    println(max(t))
    println(min(t))
    println(depth(t))
    println(sort(t))
  }
}

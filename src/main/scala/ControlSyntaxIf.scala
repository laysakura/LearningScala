object ControlSyntaxIf {
  def main(args: Array[String]): Unit = {
    val age = 5
    val isSchoolStarted = false

    println(if (age <= 6) "幼児です" else "幼児ではありません")
  }
}

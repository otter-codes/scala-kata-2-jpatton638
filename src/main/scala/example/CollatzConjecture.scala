package example

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object CollatzConjecture extends scala.App {

  try {
    lazy val number = StdIn.readLine("Enter a number: ").toInt
    val runningTotal = ListBuffer[Int](number)
    count(number, runningTotal)
  } catch {
    case ex: NumberFormatException => println("Not a number")
  }

  def count(input: Int, buffer: ListBuffer[Int]): Int = {

    (input compare 1).signum match {

    case 1 =>
      if (input % 2 == 0) {
        val newNum = input / 2
        buffer.append(newNum)
        count(newNum, buffer)
      } else {
        val newNum = (input * 3) + 1
        buffer.append(newNum)
        count(newNum, buffer)
      }
    case 0 =>
      val list = buffer.toList
      println(s"${list.head} needs ${list.length} operations")
      println(list)
      list.length
    case -1 =>
      println("Value less than 1")
      0
    }
  }
}
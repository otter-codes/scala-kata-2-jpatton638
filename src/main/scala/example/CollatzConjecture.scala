package example

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object CollatzConjecture extends scala.App {

  def calculate(number: Int): Int = {

    val runningTotal = ListBuffer[Int](number)

    count(number)

    def count(input: Int): Int = {

      if (input > 1) {
          val even = input % 2 == 0
          even match {
            case true =>
              val newNum = input / 2
              runningTotal.append(newNum)
              count(newNum)
            case false =>
              val newNum = (input * 3) + 1
              runningTotal.append(newNum)
              count(newNum)
          }
      } else {
        val list = runningTotal.toList
        println(s"$number needs a Collatz Conjecture of ${list.length}")
        println(list)
        input
      }
    }
    number
  }



  lazy val number = StdIn.readLine("Enter a number: ").toInt

  if (number < 1) {
    println("Idiot")
  }

  try {
    calculate(number)
  } catch {
    case e: NumberFormatException => println("Not a number")
  }

}
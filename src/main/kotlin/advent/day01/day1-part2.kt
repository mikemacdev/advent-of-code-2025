package advent.day01

import java.io.File

fun main() {
    data class Dial(var num: Int = 50, var timesOnZero: Int = 0) {

        fun rotateLeft(clicks: Int): Int {
            val previousNum = num
            num -= clicks % 100
            if (num < 0)
                num += 100

            val passesZeroCount = (clicks / 100) + if (num > previousNum && previousNum != 0) 1 else 0
            timesOnZero += passesZeroCount
            timesOnZero += if (num == 0) 1 else 0
            return passesZeroCount
        }

        fun rotateRight(clicks: Int): Int {
            val previousNum = num
            num = (num + clicks) % 100

            val passedZeroCount = (clicks / 100) + if (num < previousNum && num != 0) 1 else 0
            timesOnZero += passedZeroCount
            timesOnZero += if (num == 0) 1 else 0
            return passedZeroCount
        }

    }

    val dial = Dial()
    println("The dial starts by pointing at ${dial.num}.")

    val input = File("src/main/kotlin/advent/day01/day1-example.txt").readLines()
    input.map { rotation ->
        val direction = rotation[0]
        val clicks = rotation.substringAfter(direction).toInt()

        val passedZeroCount = if (direction == 'L')
            dial.rotateLeft(clicks)
        else
            dial.rotateRight(clicks)

        println("The dial is rotated $rotation to point at ${dial.num}"
                + "; during this rotation, it passed zero $passedZeroCount times.")
    }

    println("\nThe dial pointed at 0 a total of ${dial.timesOnZero} times.")
}
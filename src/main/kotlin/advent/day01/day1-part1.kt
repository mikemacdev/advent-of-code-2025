package advent.day01

import java.io.File

fun main() {
    data class Dial(var num: Int = 50, var timesOnZero: Int = 0) {

        fun rotateLeft(clicks: Int) {
            num -= clicks % 100
            if (num < 0)
                num += 100

            if (num == 0)
                timesOnZero++
        }

        fun rotateRight(clicks: Int) {
            num = (num + clicks) % 100

            if (num == 0)
                timesOnZero++
        }

    }

    val dial = Dial()
    println("The dial starts by pointing at ${dial.num}.")

    File("src/main/kotlin/advent/day01/day1-input.txt").readLines().map { rotation ->
        val direction = rotation[0]
        val clicks = rotation.substringAfter(direction).toInt()

        if (direction == 'L')
            dial.rotateLeft(clicks)
        else
            dial.rotateRight(clicks)

        println("The dial is rotated $rotation to point at ${dial.num}.")
    }

    println("\nThe dial pointed at 0 a total of ${dial.timesOnZero} times.")
}
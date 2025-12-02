package advent

import java.io.File

data class Dial(var num: Int = 50, var timesOnZero: Int = 0) {

    fun rotateLeft(clicks: Int) {
        num -= clicks % 100
        if (num < 0)
            num += 100
        checkIfOnZero()
    }

    fun rotateRight(clicks: Int) {
        num = (num + clicks) % 100
        checkIfOnZero()
    }

    private fun checkIfOnZero() { if (num == 0) timesOnZero++ }

}

fun main() {
    val dial = Dial()
    println("The dial starts by pointing at ${dial.num}.")

    val input = File("src/main/kotlin/advent/Day01-input.txt").readLines()
    input.map { rotation ->
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
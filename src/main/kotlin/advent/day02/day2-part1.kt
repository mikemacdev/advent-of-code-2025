package advent.day02

import java.io.File

fun main() {
    val sum = File("src/main/kotlin/advent/day02/day2-input.txt").readText()
        .split(',')
        .flatMap { idRange ->
            val low = idRange.substringBefore('-').toLong()
            val high = idRange.substringAfter('-').toLong()
            (low .. high)
        }.mapNotNull { number ->
            val numString = number.toString()
            if (numString.length % 2 == 0) {
                val halfLength = numString.length / 2
                if (numString.take(halfLength) == numString.takeLast(halfLength)) {
                    println("invalid id: $numString")
                    return@mapNotNull number
                }
            }
            return@mapNotNull null
        }.sum()

    println("\nSum of invalid ids: $sum")
}
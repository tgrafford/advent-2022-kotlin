package se.grafford.advent2022

class Day10(val input: List<String>) {

    fun solvePart1(): Int = instructions()
        .withIndex()
        .filter { (i, _) -> i == 19 || i >= 59 && (i - 19) % 40 == 0 }
        .sumOf { (i, v) -> (i + 1) * v }

    fun solvePart2(): String = instructions()
        .runningFoldIndexed("") { index, _, x ->
            if (index % 40 in x - 1..x + 1) {
                "#"
            } else {
                "."
            }
        }
        .joinToString("")
        .dropLast(1)
        .chunked(40)
        .joinToString("\n")

    private fun instructions() = input
            .asSequence()
            .flatMap {
                val instruction = it.split(" ")
                sequence {
                    yield(0)
                    when (instruction[0]) {
                        "addx" -> yield(instruction[1].toInt())
                    }
                }
            }
            .runningFold(1) { prev, curr -> prev + curr }
}
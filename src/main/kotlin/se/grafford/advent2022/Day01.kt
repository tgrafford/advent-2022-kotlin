package se.grafford.advent2022

class Day01(val input: List<String>) {

    fun solvePart1(): Int = caloriesPerElf()
        .max()

    fun solvePart2(): Int = caloriesPerElf()
        .sortedDescending()
        .take(3)
        .sum()

    private fun caloriesPerElf() = input
            .map { it.toIntOrNull() }
            .fold(mutableListOf(0)) { acc, i ->
                acc.apply {
                    if (i == null)
                        add(0)
                    else
                        set(size - 1, last().plus(i))
                }
            }
}
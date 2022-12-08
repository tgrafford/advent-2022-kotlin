package se.grafford.advent2022

class Day08(val input: List<String>) {

    fun solvePart1(): Int {
        val grid = input.map { it.map(Char::digitToInt) }
        var count = 0
        for (i in grid.indices) {
            val row = grid[i]
            for (j in row.indices) {
                val current = row[j]
                val left = (0 until j).maxOfOrNull { row[it] } ?: -1
                val right = (j + 1 until row.size).maxOfOrNull { row[it] } ?: -1
                val up = (0 until i).maxOfOrNull { grid[it][j] } ?: -1
                val down = (i + 1 until grid.size).maxOfOrNull { grid[it][j] } ?: -1
                if (listOf(left, right, up, down).any { current > it }) {
                    count++
                }
            }
        }
        return count
    }

    fun solvePart2(): Int {
        val grid = input.map { it.map(Char::digitToInt) }
        var maxScenicScore = 0
        for (i in 1 until grid.size - 1) {
            val row = grid[i]
            for (j in 1 until row.size - 1) {
                val current = row[j]
                val left = (j - 1 downTo 1).map { row[it] }.takeWhile { current > it }.count() + 1
                val right = (j + 1 until row.size - 1).map { row[it] }.takeWhile { current > it }.count() + 1
                val up = (i - 1 downTo 1).map { grid[it][j] }.takeWhile { current > it }.count() + 1
                val down = (i + 1 until grid.size - 1).map { grid[it][j] }.takeWhile { current > it }.count() + 1
                maxScenicScore = maxOf(up * left * down * right, maxScenicScore)
            }
        }
        return maxScenicScore
    }
}
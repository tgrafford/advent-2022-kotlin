package se.grafford.advent2022

class Day06(val input: String) {

    fun solvePart1(): Int = getMarker(4)

    fun solvePart2(): Int = getMarker(14)

    private fun getMarker(bufferSize: Int): Int {
        val buffer = CharArray(bufferSize)
        for (i in input.indices) {
            buffer[i % bufferSize] = input[i]
            if (i >= (bufferSize - 1) && buffer.toSet().size == bufferSize) {
                return i + 1
            }
        }
        return -1
    }
}
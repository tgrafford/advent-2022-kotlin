package se.grafford.advent2022

class Day06Optimized(val input: String) {

    fun solvePart1(): Int = getMarker(4)

    fun solvePart2(): Int = getMarker(14)

    private fun getMarker(bufferSize: Int): Int {
        for (index in input.indices) {
            val end = index + bufferSize
            val chars = input.subSequence(index, end)
            if (isMarker(chars))
                return end
        }
        return -1
    }

    private fun isMarker(chars: CharSequence): Boolean {
        var seen = 0
        for (c in chars) {
            val bit = 1 shl (c - 'a')
            if (seen and bit != 0)
                return false
            seen = seen or bit
        }
        return true
    }
}
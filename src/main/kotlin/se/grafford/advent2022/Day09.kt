package se.grafford.advent2022

import kotlin.math.absoluteValue
import kotlin.math.sign

class Day09(val input: List<String>) {

    fun solvePart1(): Int = moves()
        .follow()
        .distinct()
        .count()

    fun solvePart2(): Int = moves()
        .follow() // 1
        .follow() // 2
        .follow() // 3
        .follow() // 4
        .follow() // 5
        .follow() // 6
        .follow() // 7
        .follow() // 8
        .follow() // 9
        .distinct()
        .count()

    private fun moves() = input
        .asSequence()
        .map { it.split(" ") }
        .flatMap { (dir, steps) ->
            sequence {
                repeat(steps.toInt()) {
                    yield(dir)
                }
            }
        }
        .runningFold(Position(0, 0)) { head, direction ->
            when (direction) {
                "U" -> head.copy(y = head.y - 1)
                "D" -> head.copy(y = head.y + 1)
                "L" -> head.copy(x = head.x - 1)
                "R" -> head.copy(x = head.x + 1)
                else -> error("Unknown direction: $direction")
            }
        }

    private fun Sequence<Position>.follow(): Sequence<Position> =
        runningFold(Position(0, 0)) { tail, head -> tail.moveTo(head) }

    data class Position(val x: Int, val y: Int)

    private fun Position.moveTo(newPosition: Position): Position {
        val dx = newPosition.x - x
        val dy = newPosition.y - y
        return when {
            dx.absoluteValue <= 1 && dy.absoluteValue <= 1 -> this
            dx.absoluteValue < dy.absoluteValue -> newPosition.copy(y = newPosition.y - dy.sign)
            dx.absoluteValue > dy.absoluteValue -> newPosition.copy(x = newPosition.x - dx.sign)
            else -> Position(x = newPosition.x - dx.sign, y = newPosition.y - dy.sign)
        }
    }
}
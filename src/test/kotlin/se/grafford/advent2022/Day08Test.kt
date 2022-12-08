package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day08Test : ShouldSpec({

    val example = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day08(example).solvePart1() shouldBe 21
        }

        should("solve the answer") {
            Day08(readResourceLines("day08.txt")).solvePart1() shouldBe 1672
        }
    }

    context("Part 2") {
        should("match example") {
            Day08(example).solvePart2() shouldBe 8
        }

        should("solve the answer") {
            Day08(readResourceLines("day08.txt")).solvePart2() shouldBe 327180
        }
    }
})
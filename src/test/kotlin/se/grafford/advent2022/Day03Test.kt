package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day03Test : ShouldSpec({

    val example = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent().lines()

    context("Part 1") {
        should("match example") {
            Day03(example).solvePart1() shouldBe 157
        }

        should("solve the answer") {
            Day03(readResource("day03.txt")).solvePart1() shouldBe 7793
        }
    }

    context("Part 2") {
        should("match example") {
            Day03(example).solvePart2() shouldBe 70
        }

        should("solve the answer") {
            Day03(readResource("day03.txt")).solvePart2() shouldBe 2499
        }
    }
})
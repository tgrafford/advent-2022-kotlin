package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day06OptimizedTest : ShouldSpec({

    val example1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    val example2 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    val example3 = "nppdvjthqldpwncqszvftbrmjlhg"
    val example4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
    val example5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

    context("Part 1") {
        should("match example") {
            Day06Optimized(example1).solvePart1() shouldBe 7
            Day06Optimized(example2).solvePart1() shouldBe 5
            Day06Optimized(example3).solvePart1() shouldBe 6
            Day06Optimized(example4).solvePart1() shouldBe 10
            Day06Optimized(example5).solvePart1() shouldBe 11
        }

        should("solve the answer") {
            Day06Optimized(readResource("day06.txt")).solvePart1() shouldBe 1538
        }
    }

    context("Part 2") {
        should("match example") {
            Day06Optimized(example1).solvePart2() shouldBe 19
            Day06Optimized(example2).solvePart2() shouldBe 23
            Day06Optimized(example3).solvePart2() shouldBe 23
            Day06Optimized(example4).solvePart2() shouldBe 29
            Day06Optimized(example5).solvePart2() shouldBe 26
        }

        should("solve the answer") {
            Day06Optimized(readResource("day06.txt")).solvePart2() shouldBe 2315
        }
    }
})
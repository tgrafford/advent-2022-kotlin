package se.grafford.advent2022

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day11Test : ShouldSpec({

    val example = """
        Monkey 0:
          Starting items: 79, 98
          Operation: new = old * 19
          Test: divisible by 23
            If true: throw to monkey 2
            If false: throw to monkey 3
        
        Monkey 1:
          Starting items: 54, 65, 75, 74
          Operation: new = old + 6
          Test: divisible by 19
            If true: throw to monkey 2
            If false: throw to monkey 0
        
        Monkey 2:
          Starting items: 79, 60, 97
          Operation: new = old * old
          Test: divisible by 13
            If true: throw to monkey 1
            If false: throw to monkey 3
        
        Monkey 3:
          Starting items: 74
          Operation: new = old + 3
          Test: divisible by 17
            If true: throw to monkey 0
            If false: throw to monkey 1
    """.trimIndent()

    context("Part 1") {
        should("match example") {
            Day11(example).solvePart1() shouldBe 10605L
        }

        should("solve the answer") {
            Day11(readResource("day11.txt")).solvePart1() shouldBe 57348L
        }
    }

    context("Part 2") {
        should("match example") {
            Day11(example).solvePart2() shouldBe 2713310158L
        }

        should("solve the answer") {
            Day11(readResource("day11.txt")).solvePart2() shouldBe 14106266886L
        }
    }
})
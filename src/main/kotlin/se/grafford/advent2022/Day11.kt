package se.grafford.advent2022

import java.util.Stack
import kotlin.math.floor

class Day11(input: String) {

    private val digits = "\\d+".toRegex()
    private val monkeys: List<Monkey> = getMonkeys(input)

    fun solvePart1(): Long {
        repeat(20) {
            simulateRound { item -> floor(item / 3f).toLong() }
        }
        return getMonkeyBusiness()
    }

    fun solvePart2(): Long {
        val lcm = monkeys.lcmOf { it.divisor }
        repeat(10000) {
            simulateRound { item -> item % lcm }
        }
        return getMonkeyBusiness()
    }

    private fun simulateRound(reduce: (Long) -> Long) {
        monkeys.forEach { monkey ->
            while (monkey.items.isNotEmpty()) {
                val item = reduce(monkey.inspect())
                if (item % monkey.divisor == 0L)
                    monkeys[monkey.idxIfTrue].items.push(item)
                else
                    monkeys[monkey.idxIfFalse].items.push(item)
            }
        }
    }

    private fun getMonkeys(input: String): List<Monkey> = input
        .split("\n\n")
        .map {
            val lines = it.split("\n")
            val items = digits.findAll(lines[1]).map(MatchResult::value).map(String::toLong)
            val opValue = digits.find(lines[2])?.value?.toIntOrNull()
            Monkey(
                items = Stack<Long>().apply { addAll(items) },
                operation = if ('+' in lines[2]) Add(opValue) else Multiply(opValue),
                divisor = digits.find(lines[3])!!.value.toLong(),
                idxIfTrue = digits.find(lines[4])!!.value.toInt(),
                idxIfFalse = digits.find(lines[5])!!.value.toInt()
            )
        }

    private fun getMonkeyBusiness(): Long = monkeys
        .map { it.inspections }
        .sortedDescending()
        .take(2)
        .reduce { a, b -> a * b }

    sealed class Operation {
        abstract operator fun invoke(item: Long): Long
    }

    class Add(private val value: Int?) : Operation() {
        override fun invoke(item: Long): Long = item + if (value == null) item + item else item + value
    }

    class Multiply(private val value: Int?) : Operation() {
        override fun invoke(item: Long): Long = if (value == null) item * item else item * value
    }

    class Monkey(
        val items: Stack<Long>,
        val operation: Operation,
        val divisor: Long,
        val idxIfTrue: Int,
        val idxIfFalse: Int
    ) {
        var inspections: Long = 0L

        fun inspect(): Long = operation(items.pop()).also { inspections++ }
    }
}
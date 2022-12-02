package se.grafford.advent2022

class Day02(val input: List<String>) {

    val rock = 1
    val paper = 2
    val scissors = 3

    val win = 6
    val draw = 3
    val loss = 0

    val opponentShapeTranslation = mapOf("A" to rock, "B" to paper, "C" to scissors)
    val playerShapeTranslation = mapOf("X" to rock, "Y" to paper, "Z" to scissors)
    val beats = mapOf(rock to scissors, scissors to paper, paper to rock)

    val playerOutcomeTranslation = mapOf("X" to loss, "Y" to draw, "Z" to win)
    val beatenBy = beats.entries.associateBy({ it.value }) { it.key }

    fun solvePart1(): Int = input
        .map { it.split(" ") }
        .map { (opponent, player) -> opponentShapeTranslation[opponent]!! to playerShapeTranslation[player]!! }
        .sumOf { (opponentShape, playerShape) ->
            val outcome = if (beats[playerShape] == opponentShape)
                win
            else if (beats[opponentShape] == playerShape)
                loss
            else
                draw
            outcome + playerShape
        }

    fun solvePart2(): Int = input
        .map { it.split(" ") }
        .map { (shape, outcome) -> opponentShapeTranslation[shape]!! to playerOutcomeTranslation[outcome]!! }
        .sumOf { (opponentShape, outcomeScore) ->
            val playerShape = when (outcomeScore) {
                win -> beatenBy[opponentShape]!!
                loss -> beats[opponentShape]!!
                else -> opponentShape
            }
            outcomeScore + playerShape
        }
}
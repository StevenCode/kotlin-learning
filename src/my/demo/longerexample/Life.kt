package my.demo.longerexample

class Field(
        val width: Int,
        val height: Int,

        init: (Int, Int) -> Boolean
) {
    private val live: Array<Array<Boolean>> = Array(height) { i ->
        Array(width) { j -> init(i, j) }
    }

    private fun liveCount(i: Int, j: Int) = if (i in 0..height - 1 && j in 0..width - 1 && live[i][j]) 1 else 0

    fun liveNeighbors(i: Int, j: Int) = liveCount(i - 1, j - 1) +
            liveCount(i - 1, j) +
            liveCount(i - 1, j + 1) +
            liveCount(i, j - 1) +
            liveCount(i, j + 1) +
            liveCount(i + 1, j - 1) +
            liveCount(i + 1, j) +
            liveCount(i + 1, j + 1)


    operator fun get(i: Int, j: Int) = live[i][j]

}



fun next(field: Field): Field {
    return Field(field.width, field.height) { i, j ->
        val n = field.liveNeighbors(i, j)
        if (field[i, j])
            n in 2..3
        else
            n == 3
    }
}

/** A few colony examples here */
fun main(args: Array<String>) {
    // Simplistic demo
    runGameOfLife("***", 3)
    // "Star burst"
    runGameOfLife("""
        _______
        ___*___
        __***__
        ___*___
        _______
    """, 10)
    // Stable colony
    runGameOfLife("""
        _____
        __*__
        _*_*_
        __*__
        _____
    """, 3)
    // Stable from the step 2
    runGameOfLife("""
        __**__
        __**__
        __**__
    """, 3)
    // Oscillating colony
    runGameOfLife("""
        __**____
        __**____
        ____**__
        ____**__
    """, 6)
    // A fancier oscillating colony
    runGameOfLife("""
        -------------------
        -------***---***---
        -------------------
        -----*----*-*----*-
        -----*----*-*----*-
        -----*----*-*----*-
        -------***---***---
        -------------------
        -------***---***---
        -----*----*-*----*-
        -----*----*-*----*-
        -----*----*-*----*-
        -------------------
        -------***---***---
        -------------------
    """, 10)
}

fun runGameOfLife(fieldText: String, steps: Int) {
    var field = makeField(fieldText)
    for (step in 1..steps) {
        println("Step:$step")
        for (i in 0..field.height - 1) {
            for (j in 0..field.width - 1) {
                print(if (field[i, j]) "*" else " ")
            }
            println("")
        }
        field = next(field)
    }
}

fun makeField(s: String): Field {
    val lines = s.replace(" ", "").split('\n').filter { it.isNotEmpty() }
    val longestLine = lines.toList().maxBy { it.length } ?: ""

    return Field(longestLine.length, lines.size) { i, j ->
        lines[i][j] == '*'
    }
}

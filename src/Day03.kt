import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        val length = input[0].length
        val gamma = IntArray(length)
        val epsilon = IntArray(length)

        for(i in 0 until length) {
            var x: Int = 0 // 0
            var y: Int = 0 // 1
            for(line in input) {
                when(line[i].digitToInt()) {
                    0 -> x++
                    1 -> y++
                }
            }
            if (x>y) gamma[i] = 0 else gamma[i] = 1
            if (x>y) epsilon[i] = 1 else epsilon[i] = 0
        }

        return gamma.joinToString("").toInt(2)*epsilon.joinToString("").toInt(2)
    }

    fun part2(input: List<String>): Int {


        return 0
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

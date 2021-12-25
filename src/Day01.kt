fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.toInt() }.zipWithNext().count { (a, b) -> a < b }
    }

    fun part2(input: List<String>): Int {
        val i = input.map { it.toInt() }
        return i.windowed(3).map { it.sum() }.zipWithNext().count { (a, b) -> a < b }
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

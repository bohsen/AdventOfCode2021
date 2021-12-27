fun main() {
    val input = readInput("Day03")

    val length = input[0].length
    val gamma = IntArray(length)
    val epsilon = IntArray(length)

    fun part1(input: List<String>): Int {
        for (i in 0 until length) {
            var countX = 0 // 0
            var countY = 0 // 1
            for (line in input) {
                when (line[i].digitToInt()) {
                    0 -> countX++
                    1 -> countY++
                }
            }

            println("Position: $i: Count 0 bits: $countX. Count 1 bits: $countY")
            if (countX > countY) gamma[i] = 0 else gamma[i] = 1
            if (countX > countY) epsilon[i] = 1 else epsilon[i] = 0
        }

        println("Most common values: ${gamma.joinToString("")}. Least common values: ${epsilon.joinToString("")}")
        return gamma.joinToString("").toInt(2)*epsilon.joinToString("").toInt(2)
    }

    fun part2(input: List<String>): Int {

        val mostCommonValue = gamma.joinToString("")
        val leastCommonValue = epsilon.joinToString("")

        fun search(common: Boolean): String {
            val n = input[0].length
            var rem = input
            var i = 0
            while (i < n && rem.size > 1) {
                var count0 = 0
                var count1 = 0
                for (line in rem) {
                    when (line[i]) {
                        '0' -> count0++
                        '1' -> count1++
                    }
                }
                println("Count0: $count0. Count1: $count1")
                val keep = if (common) {
                    if (count1 >= count0) '1' else '0'
                } else {
                    if (count0 <= count1) '0' else '1'
                }
                rem = rem.filter { line -> line[i] == keep }
                i++
            }
            return rem.first()
        }

        val oxygenGeneratorRating = search(true)
        val co2ScrubberRating = search(false)

        println("Oxygen generator rating: $oxygenGeneratorRating. Co2 Scrubber Rating: $co2ScrubberRating")
        return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    println(part1(input))
    println(part2(input))
}

package second

fun main(args: Array<String>) {
    val firstSplittedRow = readln().split(" ")
    val daysCount = firstSplittedRow[0].toInt()
    val maxDays = firstSplittedRow[1].toInt()

    val prices = readln().split(" ").map { it.toInt() }

    var res = 0

    prices.forEachIndexed { index, price ->
        if (index != 0) {
            var tempIndex = index
            while (tempIndex >= 0 && index - tempIndex <= maxDays) {
                if (prices[index] - prices[tempIndex] > res) res = prices[index] - prices[tempIndex]
                tempIndex--
            }
        }
    }

    println(res)
}

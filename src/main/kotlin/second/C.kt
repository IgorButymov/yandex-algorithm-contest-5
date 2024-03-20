package second

fun main(args: Array<String>) {
    val n = readln().toInt()

    val lengths = readln().split(" ").map { it.toInt() }.sorted()

    var max = lengths.last()
    val tempMax = max
    var sum = 0

    lengths.subList(0, lengths.size - 1).forEach {  length ->
        sum += length
        max -= length
    }

    if (max <= 0) println(sum + lengths.last()) else println(max)

}
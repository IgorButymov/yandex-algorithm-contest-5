package second

fun main(args: Array<String>) {
    val t = readln().toInt()

    val arrays = mutableListOf<List<Int>>()

    for (i in 1..t) {
        val n = readln().toInt()
        val array = readln().split(" ").map { it.toInt() }
        arrays.add(array)
    }

    for (array in arrays) {
        val tempRes = mutableListOf<List<Int>>()
        val tempList = mutableListOf<Int>()
        var min = array.first()

        array.forEachIndexed { index, num ->
            if (num >= tempList.size + 1 && min > tempList.size) {
                tempList.add(num)
                if (num < min) min = num
            } else {
                tempRes.add(tempList.toList())
                tempList.clear()
                tempList.add(num)
                min = num
            }
        }

        tempRes.add(tempList)
        println(tempRes.size)
        for (list in tempRes) {
            print(list.size)
            print(" ")
        }
        println()
    }
}
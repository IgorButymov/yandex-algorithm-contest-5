package third

fun main(args: Array<String>) {
    val map = mutableMapOf<Int, Int>()
    for (i in 1..3) {
        val n = readln()
        val nums = readln().split(" ").map { it.toInt() }.toSet().forEach {
            val existed = map.get(it)
            if (existed != null) {
                map.put(it, existed + 1)
            } else {
                map.put(it, 1)
            }
        }
    }

    val res = mutableListOf<Int>()

    for (entry in map.entries) {
        if (entry.value >= 2) {
            res.add(entry.key)
        }
    }

    for (item in res.sorted()) {
        print(item)
        print(" ")
    }
}
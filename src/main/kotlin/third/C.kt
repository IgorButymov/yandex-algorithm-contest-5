package third

fun main(args: Array<String>) {
    readln()
    val nums = readln().split(" ").map { it.toInt() }

    if (nums.size == 1) {
        println(0)
        return
    }

    val map = sortedMapOf<Int, Int>()

    for (num in nums) {
        val existed = map[num]

        if (existed == null) {
            map[num] = 1
        } else {
            map[num] = existed + 1
        }
    }

    var prev = Pair(-1, -1)
    var res = 0

    for (entry in map.entries) {
        if (prev.first != -1) {
            val diff = Math.abs(prev.first - entry.key)
            if (diff <= 1) {
                if (prev.second + entry.value > res) {
                    res = prev.second + entry.value
                }
            }
        }
        prev = Pair(entry.key, entry.value)
    }

    if (res == nums.size || (res == 0 && (map.size==1))) {
        println(0)
        return
    } else if (res == 0 && map.size == nums.size) {
        println(nums.size -1)
        return
    }

    println(nums.size - res)
}
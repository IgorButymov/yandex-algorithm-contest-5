package fourth

fun main(args: Array<String>) {
    readln()
    val nums = readln().split(" ").map { it.toInt() }.sorted()

    val k = readln().toInt()

    for (i in 1..k) {
        val request = readln().split(" ").map { it.toInt() }

        if (nums.size == 1) {
            if (nums[0] in request[0]..request[1]) print(1) else print(0)
        } else {
            val left = leftBinarySearch(nums, request[0])
            val right = rightBinarySearch(nums, request[1])

            if (right == -1 || left == -1) print(0) else print(right - left + 1)
        }

        print(" ")
    }
}

fun leftBinarySearch(nums: List<Int>, num: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val medium = (left + right) / 2

        if (nums[medium] >= num) {
            right = medium
        } else {
            left = medium + 1
        }
    }

    return if (nums[left] >= num) left else -1
}

fun rightBinarySearch(nums: List<Int>, num: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val medium = (left + right + 1) / 2

        if (nums[medium] <= num) {
            left = medium
        } else {
            right = medium - 1
        }
    }

    return if (nums[left] <= num) left else -1
}
package third

fun main(args: Array<String>) {
    val count = readln().toInt()

    val map = sortedMapOf<String, Int>()

    for (i in 1..count) {
        readln()
        val songs = readln().split(" ")
        for (song in songs) {
            val existed = map.get(song)
            if (existed != null) {
                map.put(song, existed + 1)
            } else {
                map.put(song, 1)
            }
        }
    }

    var resCount = 0
    val res = mutableListOf<String>()

    for (entry in map.entries) {
        if (entry.value >= count) {
            resCount++
            res.add(entry.key)
        }
    }

    println(resCount)
    println(res.joinToString(" "))
}
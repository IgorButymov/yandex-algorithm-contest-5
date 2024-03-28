package third

fun main(args: Array<String>) {
    val first = readln()
    val second = readln()
    if (first.length != second.length) {
        println("NO")
        return
    }

    val mapFirst = mutableMapOf<Char, Int>()
    val mapSecond = mutableMapOf<Char, Int>()

    for (char in first) {
        val existed = mapFirst.get(char)
        if (existed != null) {
            mapFirst.put(char, existed + 1)
        } else {
            mapFirst.put(char, 1)
        }
    }

    for (char in second) {
        val existed = mapSecond.get(char)
        if (existed != null) {
            mapSecond.put(char, existed + 1)
        } else {
            mapSecond.put(char, 1)
        }
    }

    if (mapFirst == mapSecond) println("YES") else println("NO")
}

package third

fun main(args: Array<String>) {
    val dictionary = readln().split(" ")
    val dictionary2 = mutableMapOf<String, String>()

    for (elem in dictionary) {
        dictionary2[elem] = elem
    }

    readln().split(" ").forEach { word ->
        var tempRes = word
        for (i in 0..word.length - 1) {
            val index = word.substring(0..i)
            val existed = dictionary2[index]
            if (existed != null) {
                tempRes = existed
                break
            }
        }

        print(tempRes)
        print(" ")
    }
}
package first

fun main(args: Array<String>) {
    val firstScore = readLine()!!.split(":").map { it.toInt() }
    val secondScore = readLine()!!.split(":").map { it.toInt() }
    val firstHomeGame = readLine()

    val homeScore = if (firstHomeGame == "1") firstScore[0] else secondScore[0]
    var guestScore = if (firstHomeGame == "1") secondScore[0] else firstScore[0]

    var score = homeScore + guestScore
    val lastScore = score

    val enemyHomeScore = if (firstHomeGame == "1") secondScore[1] else firstScore[1]
    val enemyGuestScore = if (firstHomeGame == "1") firstScore[1] else secondScore[1]

    val enemyScore = enemyHomeScore + enemyGuestScore

    while (true) {
        if (score == enemyScore && guestScore > enemyGuestScore) {
            println(score - lastScore)
            return
        }
        if (firstHomeGame == "1") { // текущая -- в гостях
            if ((guestScore > enemyGuestScore && score >= enemyScore) || score > enemyScore) {
                println(score - lastScore)
                return
            }
            guestScore++
            score++
        } else { // firstHomeGame == "2" // текущая -- дома
            if (score > enemyScore) {
                println(score - lastScore)
                return
            }
            score++
        }
    }
}
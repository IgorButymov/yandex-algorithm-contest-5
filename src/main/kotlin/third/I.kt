package third

import java.io.BufferedReader
import java.io.File

// Total goals for <Название команды> — количество голов, забитое данной командой за все матчи.
// Mean goals per game for <Название команды> — среднее количество голов, забиваемое данной командой за один матч. Гарантирутся, что к моменту подачи такого запроса команда уже сыграла хотя бы один матч.
// Total goals by <Имя игрока> — количество голов, забитое данным игроком за все матчи.
// Mean goals per game by <Имя игрока> — среднее количество голов, забиваемое данным игроком за один матч его команды. Гарантирутся, что к моменту подачи такого запроса игрок уже забил хотя бы один гол.
// Goals on minute <Минута> by <Имя игрока> — количество голов, забитых данным игроком ровно на указанной минуте матча
// Goals on first <T> minutes by <Имя игрока> — количество голов, забитых данным игроком на минутах с первой по T-ю включительно
// Goals on last <T> minutes by <Имя игрока> — количество голов, забитых данным игроком на минутах с (91 - T)-й по 90-ю включительно
// Score opens by <Название команды> — сколько раз данная команда открывала счет в матче
// Score opens by <Имя игрока> — сколько раз данный игрок открывал счет в матче

fun main(args: Array<String>) {
    val urlMatcher = "\"(.+)\"".toRegex()

    val bufferedReader: BufferedReader = File("input.txt").bufferedReader()
    val splitted = bufferedReader.readText().trim().split("\n")

    var gamesCount = 0
    val teamsGoals = mutableMapOf<String, Int>()
    val teamsGames = mutableMapOf<String, Int>()
    val playersTeams = mutableMapOf<String, String>()
    val playersGoals = mutableMapOf<String, Int>()
    val playersMinutes = mutableMapOf<String, List<Int>>()
    val teamsOpen = mutableMapOf<String, Int>()
    val playersOpen = mutableMapOf<String, Int>()

    val teams = mutableSetOf<String>()

    var firstCounter = -1
    var secondCounter = -1

    var firstTempName = ""
    var secondTempName = ""

    var minTempMinute = Int.MAX_VALUE
    var minTempPlayer = ""
    var minTempTeam = ""

    for (string in splitted) {
        if (string.startsWith("\"")) {
            if (minTempTeam != "") {
                val existedTeamsOpen = teamsOpen[minTempTeam]
                if (existedTeamsOpen == null) {
                    teamsOpen[minTempTeam] = 1
                } else {
                    teamsOpen[minTempTeam] = existedTeamsOpen + 1
                }
            }

            if (minTempPlayer != "") {
                val existedPlayersOpen = playersOpen[minTempPlayer]
                if (existedPlayersOpen == null) {
                    playersOpen[minTempPlayer] = 1
                } else {
                    playersOpen[minTempPlayer] = existedPlayersOpen + 1
                }
            }

            firstCounter = -1
            secondCounter = -1

            firstTempName = ""
            secondTempName = ""

            minTempMinute = Int.MAX_VALUE
            minTempPlayer = ""
            minTempTeam = ""

            val splittedGame = string.split(" ")
            val firstName = urlMatcher.find(string.substringBefore("-"))?.groupValues!!.get(1)
            val secondName = urlMatcher.find(string.substringAfter("-"))?.groupValues!!.get(1)
            val score = splittedGame.last().split(":")
            val firstScore = score[0].toInt()
            val secondScore = score[1].toInt()

            val existedFirstTeamsGoals = teamsGoals[firstName]
            if (existedFirstTeamsGoals == null) teamsGoals[firstName] = firstScore else teamsGoals[firstName] = existedFirstTeamsGoals + firstScore

            val existedSecondTeamsGoals = teamsGoals[secondName]
            if (existedSecondTeamsGoals == null) teamsGoals[secondName] = secondScore else teamsGoals[secondName] = existedSecondTeamsGoals + secondScore

            val existedFirstTeamsGames = teamsGames[firstName]
            if (existedFirstTeamsGames == null) teamsGames[firstName] = 1 else teamsGames[firstName] = existedFirstTeamsGames + 1

            val existedSecondTeamsGames = teamsGames[secondName]
            if (existedSecondTeamsGames == null) teamsGames[secondName] = 1 else teamsGames[secondName] = existedSecondTeamsGames + 1

            firstCounter = firstScore
            secondCounter = secondScore

            firstTempName = firstName
            secondTempName = secondName

            teams.add(firstName)
            teams.add(secondName)

            gamesCount++
        } else if (string.isNotEmpty() && string.last() == '\'') {
            val name = string.substringBeforeLast(" ")
            val minuteString = string.split(" ").last()
            val minute = minuteString.substring(0..minuteString.length - 2).toInt()

            val existedPlayersGoals = playersGoals[name]
            if (existedPlayersGoals == null) {
                playersGoals[name] = 1
            } else {
                playersGoals[name] = existedPlayersGoals + 1
            }

            val existedPlayersMinutes = playersMinutes[name]
            if (existedPlayersMinutes == null) {
                playersMinutes[name] = listOf(minute)
            } else {
                playersMinutes[name] = existedPlayersMinutes + listOf(minute)
            }

            if (firstCounter > 0) {
                playersTeams[name] = firstTempName
                if (minute < minTempMinute) {
                    minTempMinute = minute
                    minTempTeam = firstTempName
                    minTempPlayer = name
                }
                firstCounter--
            } else if (secondCounter > 0) {
                playersTeams[name] = secondTempName
                if (minute < minTempMinute) {
                    minTempMinute = minute
                    minTempTeam = secondTempName
                    minTempPlayer = name
                }
                secondCounter--
            }
        } else {
            if (minTempTeam != "") {
                val existedTeamsOpen = teamsOpen[minTempTeam]
                if (existedTeamsOpen == null) {
                    teamsOpen[minTempTeam] = 1
                } else {
                    teamsOpen[minTempTeam] = existedTeamsOpen + 1
                }
            }

            if (minTempPlayer != "") {
                val existedPlayersOpen = playersOpen[minTempPlayer]
                if (existedPlayersOpen == null) {
                    playersOpen[minTempPlayer] = 1
                } else {
                    playersOpen[minTempPlayer] = existedPlayersOpen + 1
                }
            }

            firstCounter = -1
            secondCounter = -1

            firstTempName = ""
            secondTempName = ""

            minTempMinute = Int.MAX_VALUE
            minTempPlayer = ""
            minTempTeam = ""

            // requests

            if (string.startsWith("Total goals for ")) {
                val temp = string.substringAfter("for ")
                val teamName = temp.substring(1..temp.length - 2)
                println(teamsGoals[teamName] ?: 0)
            }
            if (string.startsWith("Mean goals per game for ")) {
                val temp = string.substringAfter("for ")
                val teamName = temp.substring(1..temp.length - 2)
                val first = teamsGoals[teamName]
                val second = teamsGames[teamName]
                if (first != null && second != null) {
                    println(first.toDouble() / second)
                } else {
                    println(0)
                }
            }
            if (string.startsWith("Total goals by ")) {
                val playerName = string.substringAfter("by ")
                println(playersGoals[playerName] ?: 0)
            }
            if (string.startsWith("Mean goals per game by ")) {
                val playerName = string.substringAfter("by ")
                val teamName = playersTeams[playerName]
                val first = playersGoals[playerName]
                val second = teamsGames[teamName]
                if (first != null && second != null) {
                    println(first.toDouble() / second)
                } else {
                    println(0)
                }
            }
            if (string.startsWith("Goals on minute ")) {
                val minute = string.substringAfter("minute ").substringBefore(" by")
                val playerName = string.substringAfter("by ")
                println(playersMinutes[playerName]?.filter { it == minute.toInt() }?.size ?: 0)
            }
            if (string.startsWith("Goals on first ")) {
                val minute = string.substringAfter("first ").substringBefore(" minutes")
                val playerName = string.substringAfter("by ")
                println(playersMinutes[playerName]?.filter { it in 1..minute.toInt() }?.size ?: 0)
            }
            if (string.startsWith("Goals on last ")) {
                val minute = string.substringAfter("last ").substringBefore(" minutes")
                val playerName = string.substringAfter("by ")
                println(playersMinutes[playerName]?.filter { it in 91 - minute.toInt()..90 }?.size ?: 0)
            }
            if (string.startsWith("Score opens by ")) {
                val name = string.substringAfter("by ")
                if (name.contains("\"")) {
                    println(teamsOpen[name.substring(1..name.length - 2)] ?: 0)
                } else {
                    println(playersOpen[name] ?: 0)
                }
            }
        }
    }
}
package lesson5

fun main() {
    // 1. Текст в коды
    println("Введите слово:")
    val word = readln()

    println("Коды букв:")
    for (letter in word) {
        println("$letter = ${letter.code}")
    }

    println("\n" + "*".repeat(20))

    // 2. Коды в текст
    println("Введите коды через пробел:")
    val codes = readln().split(" ")

    var result = ""
    for (code in codes) {
        if (code.isNotEmpty()) {
            result += code.toInt().toChar()
        }
    }
    println("Текст: $result")
}
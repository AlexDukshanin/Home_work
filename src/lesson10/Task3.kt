package lesson10

//IllegalArgumentException

fun main() {
    try {
        print("Введите строку: ")
        val input = readLine() ?: throw IllegalArgumentException("Строка отсутствует")
        if (input.isBlank()) throw IllegalArgumentException("Строка пустая")

        println("Введено: $input")
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
    }
}
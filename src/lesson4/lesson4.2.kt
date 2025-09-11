package lesson4

fun main() {
    // Пример массива
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2, -3)

    // Подсчет четных и нечетных чисел
    var evenCount = 0
    var oddCount = 0

    for (number in numbers) {
        if (number % 2 == 0) {
            evenCount++
        } else {
            oddCount++
        }
    }

    // Вывод результатов
    println("Массив: ${numbers.joinToString(", ")}")
    println("Количество четных чисел: $evenCount")
    println("Количество нечетных чисел: $oddCount")
    println("Всего чисел: ${numbers.size}")
}
package lesson6

fun main() {
    val numbers = arrayOf(4, -3, 2, -1, 0, -5)
    val sortedNumbers = sort(numbers)

    println("Исходный массив: ${numbers.contentToString()}")
    println("Отсортированный массив: ${sortedNumbers.contentToString()}")
}

fun sort(arr: Array<Int>): Array<Int> {
    val result = Array(arr.size) { 0 }
    var index = 0

    // Добавляем отрицательные числа
    for (num in arr) {
        if (num < 0) {
            result[index++] = num
        }
    }

    // Добавляем нули
    for (num in arr) {
        if (num == 0) {
            result[index++] = num
        }
    }

    // Добавляем положительные числа
    for (num in arr) {
        if (num > 0) {
            result[index++] = num
        }
    }

    return result
}
fun main() {
    val numbers = intArrayOf(34, 12, 89, 5, 67, 23, 91, 5, 18)

    // Находим максимальное значение и индекс
    val maxValue = numbers.maxOrNull() ?: 0
    val maxIndex = numbers.indexOf(maxValue)

    val minValue = numbers.minOrNull() ?: 0
    val minIndex = numbers.indexOf(minValue)

    println("Максимальное значение: $maxValue")
    println("Индекс максимального значения: $maxIndex")

    println("Минимальное значение: $minValue")
    println("Индекс мимимального значения: $minIndex")
}
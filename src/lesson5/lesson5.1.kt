package lesson5

fun main() {
    val name = "Hello World, I am teach Kotlin"

    val words = name.split(" ")
    val reversedname = words.reversed().joinToString(" ")

    println("Исходная строка: $name")
    println("Перевернутые слова: $reversedname")
}
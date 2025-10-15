package Lesson13

//Задача 3:
//Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа,
//затем возведите их в квадрат и посчитайте сумму всех этих чисел.
//Сделайте это с использованием asSequence для ленивой обработки.

fun main() {
    val numbers = (1..10000000).toList()
    val newList = numbers.asSequence()
        .filter { it % 2 == 0 }
        .map { it * it }
        .sum()
    println(newList)

}
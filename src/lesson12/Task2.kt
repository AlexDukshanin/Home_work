package lesson12

//Задача 2: Поиск первого повторяющегося числа
//Дан список чисел, нужно найти первое число, которое повторяется.


fun main() {
    val list = listOf(3, 4, 5, 10, 7, 10)

    val list2 = list.firstOrNull { list2 ->
        list.count { it == list2 } == 2

    }
    println(list2)
}
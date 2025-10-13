package Lesson13

//Задача 2:
//Напишите программу, которая получает список людей, фильтрует только
//тех, кто старше 18 лет, затем сортирует их по возрасту в порядке
//убывания и выводит на экран с помощью apply и let. (sortedByDescending)
data class Person(val name: String, val age: Int)

fun main() {
    // Создаем список людей
    val people = mutableListOf<Person>().apply {
        add(Person("Анна", 25))
        add(Person("Иван", 17))
        add(Person("Мария", 30))
        add(Person("Петр", 16))
        add(Person("Ольга", 22))
        add(Person("Сергей", 19))
        add(Person("Елена", 35))
        add(Person("Василий", age = 34))
    }

    // Фильтруем, сортируем и выводим
    people.filter { it.age > 18 }
        .sortedByDescending { it.age }
        .let { it ->
            println("Люди старше 18 лет:")
            it.forEachIndexed { index, person ->
                println("${index + 1}. ${person.name} - ${person.age} лет")
            }
        }
}
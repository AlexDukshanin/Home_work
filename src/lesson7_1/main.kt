package lesson7_1

fun main() {
    val book1 = Book(1, "Оно", "Стивен Кинг", 1986, genre = "Ужасы")
    val book2 = Book(2, "Война и мир", "Л.Н. Толстой", 1869, genre = "История")
    val book3 = Book(3, title = "Властелин колец", author = "Толкин", year = 1954, genre = "Фэнтези")


    println(book1)
    println(book2)
    println(book3)

    println()

    // Проверка equals и hash
    println(book1 == book3)
    println(book1 == book2)
    println(book1 === book3)
    println(book1 === book2)
    println(book1 === book1)
    println(book1 == book1)

    println()


    println("book1 == book2: ${book1 == book2}")       // false
    println("book1 == book1: ${book1 == book1}")       //true

    println()

    println("book1.hashCode(): ${book1.hashCode()}")
    println("book2.hashCode(): ${book2.hashCode()}")
}
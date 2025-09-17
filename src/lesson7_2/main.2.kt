package lesson7_2

fun main() {
    val bookData1 = BookData(1, "Оно", "Стивен Кинг", 1986, genre = "Ужасы")
    val bookData2 = BookData(2, "Война и мир", "Л.Н. Толстой", 1869, genre = "История")
    val bookData3 = BookData(3, title = "Властелин колец", author = "Толкин", year = 1954, genre = "Фэнтези")

    println()

    println("bookData1 == bookData2: ${bookData1 == bookData2}")   // False
    println("bookData1 == bookData1: ${bookData1 == bookData1}")

    println()

    println("bookData1.hashCode(): ${bookData1.hashCode()}")
    println("bookData2.hashCode(): ${bookData2.hashCode()}")

    println()

    bookData1.borrow("Иван")
    bookData2.borrow("Анна")

    println()

    println(bookData1)
    println(bookData2)
    println(bookData3)
}
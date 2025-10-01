package lesson7_1

import LibraryItem

// Класс Book наследуется от LibraryItem
class Book(
    id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val genre: String
) : LibraryItem(id) {
    annotation class LibraryItem(val id: Int)

    override fun toString(): String {
        return "Book(title='$title', author='$author', year=$year, genre=$genre)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Book) return false
        return title == other.title && author == other.author
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + author.hashCode()
        return result
    }
}
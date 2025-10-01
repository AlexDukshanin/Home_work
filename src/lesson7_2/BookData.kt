package lesson7_2

import LibraryItem

// Data class Book с наследованием и реализацией Borrowable
data class BookData(
    override val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val genre: String
) : LibraryItem(id), Borrowable {

    private var borrowedBy: String? = null

    override fun borrow(user: String) {
        if (borrowedBy == null) {
            borrowedBy = user
            println("Книга '$title' взята в долг пользователем $user")
        } else {
            println("Книга '$title' уже взята в долг пользователем $borrowedBy")
        }
    }


    override fun toString(): String {
        val status = borrowedBy?.let { " (Книга у $it)" } ?: ""
        return "$title ; $author ; $year ; $genre$status"
    }
}
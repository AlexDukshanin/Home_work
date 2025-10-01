package lesson10

class TooYoungException(message: String) : Exception(message)

fun checkAge(age: Int) {
    if (age < 18) throw TooYoungException("Возраст $age — доступ запрещён (меньше 18)")
}

fun main() {
    print("Введите возраст: ")
    val age = readLine()?.toIntOrNull()
    if (age == null) {
        println("Введено не число")
        return
    }

    try {
        checkAge(age)
        println("Доступ разрешён")
    } catch (e: TooYoungException) {
        println(e.message)
    }
}
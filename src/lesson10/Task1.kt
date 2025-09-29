package lesson10


fun main() {
    try {
        println("input first number")
        val number = readLine()!!.toInt()

        println("input second number")
        val number2 = readLine()!!.toInt()

        val result = number / number2
        println("result:$result")
    } catch (e: NumberFormatException) {
        println("InputMismatchException: Введено не число")
    } catch (e: ArithmeticException) {
        println("ArithmeticException: Я Вам запрещаю делить на ноль")
    }
}
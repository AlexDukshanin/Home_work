package lesson4

fun main () {
    val num = intArrayOf(0, 1, 0, 1, 0)
    if (num.toString() == num.reversed().toString()) {
        println ("палиндром")
    } else
        println ("не палиндром")


}
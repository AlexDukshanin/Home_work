import java.util.LinkedList

fun main(){
    println("Введите кол-во человек в круге:")
    val n = readLine()?.toIntOrNull() ?:0
    val people = LinkedList<Int>()
    for (i in 1..n) {
        people.add(i)
    }

    println("Начальный круг: $people")

    var i = 0
    while (people.size > 1) {
        i = (i + 1) % people.size // переходим к следующему
        val removed = people.removeAt(i) // удаляем его
        println("Удалили $removed, остались: $people")
    }

    println("Поcледний: ${people[0]}")
}


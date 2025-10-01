import java.util.LinkedList

fun main() {
    val list1 = LinkedList(listOf(1, 3, 5))
    val list2 = LinkedList(listOf(2, 4, 6))
    val result = LinkedList<Int>()

    while (list1.isNotEmpty() && list2.isNotEmpty()) {
        result.add(if (list1.peek() < list2.peek()) list1.removeFirst() else list2.removeFirst())
    }

    result.addAll(list1)
    result.addAll(list2)

    println(result)
}
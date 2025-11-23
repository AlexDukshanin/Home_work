package lesson14Task1

//Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
//Вам нужно создать класс Counter, который будет иметь метод increment и метод
//decrement. Эти методы должны увеличивать и уменьшать значение переменной
//count в многопоточном режиме. Для синхронизации доступов используйте
//внешний объект (не объект класса).

val lock = Object()

fun main() {
    val counter = Counter()

    val incThread = Thread { repeat(100) { counter.inc() } }
    val decThread = Thread { repeat(100) { counter.dec() } }

    incThread.start()
    decThread.start()
    incThread.join()
    decThread.join()

    println("Result: ${counter.getCount()}") // Должно быть 0
}

class Counter {
    private var count = 0

    fun inc() = synchronized(lock) { count++ }
    fun dec() = synchronized(lock) { count-- }
    fun getCount() = synchronized(lock) { count }
}
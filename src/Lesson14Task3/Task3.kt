package Lesson14Task3

//Задача 3: Синхронизация потоков для предотвращения гонки данных.
//Напишите программу с двумя потоками, которые одновременно увеличивают
//и уменьшают значение счетчика. Ваша задача — обеспечить, чтобы операция
//увеличения и уменьшения была выполнена безопасно с помощью
//синхронизации.


fun main() {
    val counter = Counter()

    // Поток для увеличения счетчика
    val incThread = Thread {
        repeat(100) {
            counter.inc()
        }
    }

    // Поток для уменьшения счетчика
    val decThread = Thread {
        repeat(100) {
            counter.dec()
        }
    }

    incThread.start()
    decThread.start()
    incThread.join()
    decThread.join()

    println("Result: ${counter.getCount()}") // Должно быть 0
}

class Counter {
    private var count = 0

    @Synchronized
    fun inc() {
        count++
    }

    @Synchronized
    fun dec() {
        count--
    }

    @Synchronized
    fun getCount(): Int {
        return count
    }
}
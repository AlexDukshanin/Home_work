package lesson14Task2

//Задача 2: Применение атомарных типов для безопасного увеличения счетчика.
//Напишите программу, в которой два потока одновременно увеличивают счетчик.
//Вместо синхронизации используйте класс AtomicInteger, чтобы избежать
//блокировок.

import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val counter = Counter()

    val thread1 = Thread {
        counter.inc()
    }

    val thread2 = Thread {
        counter.inc()
    }

    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()

    // Получаем значение из AtomicInteger
    println("Result: ${counter.counter.get()}")
}

class Counter {
    // Инициализируем AtomicInteger с начальным значением 0
    val counter = AtomicInteger(0)

    fun inc() {
        for (i in 0..10) { // 11 итераций (от 0 до 10 включительно)
            counter.incrementAndGet()
        }
    }
}
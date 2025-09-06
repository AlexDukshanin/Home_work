fun main() {

    println("Выбор задачи")
    println("1 - Проверка палиндрома (математический способ)")
    println("2 - Проверка палиндрома (строковый способ)")
    println("3 - Проверка на простое число")
    println("4 - Сумма чисел до единичного разряда")
    println("5 - Лесенка")

    when (readLine()?.toIntOrNull()) {
        1 -> Lesson3_1()
        2 -> Lesson3_1_1()
        3 -> Lesson3_2()
        4 -> Lesson3_3()
        5 -> Lesson3_4()
        else -> println("Неверный выбор")
    }
}


fun Lesson3_1() {
    //Задача №1
    println("Введите число для проверки")
    var number: Int = readln().toIntOrNull() ?: 0
    when (number) {
        in 0..9 -> println("Ваше число палиндром")
        in 10..99 -> {
            if (number / 10 == number % 10) println("Ваше число палиндром")
            else println("Ваше число не палиндром")
        }

        in 100..999 -> {
            if (number / 100 == number % 10) println("Ваше число палиндром")
            else println("Ваше число не палиндром")
        }

        in 1000..9999 -> {
            val t: Int = number / 1000
            val h: Int = (number - t * 1000) / 100
            val d: Int = (number - t * 1000 - h * 100) / 10
            val o: Int = number % 10
            if (t == o && h == d) println("Ваше число палиндром, как не крути")
            else println("Ваше число не палиндром")
        }
    }
}

// Дополнительный вариант решения
fun Lesson3_1_1() {
    println("Введите число:")
    val number = readLine()!!

    // Переворачиваем число
    val reversed = number.reversed()

    // Сравниваем исходное число с перевернутым
    if (number == reversed) {
        println("Число $number является палиндромом")
    } else {
        println("Число $number не является палиндромом")
    }
}

//Задача №2, Проверка на простое число
fun Lesson3_2() {
    println("Введите число, для проверки, является ли оно простым")
    val number = readLine()!!.toInt()

    // Проверяем, является ли число простым
    if (isPrime(number)) {
        println("Число простое")
    } else {
        println("Число не является простым")
    }
}

fun isPrime(n: Int): Boolean {
    // Простые числа больше 1
    if (n <= 1) return false

    // Проверяем делители от 2 до корня из числа
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false // Найден делитель -> не простое
        }
    }
    return true // Делителей нет -> простое
}

fun Lesson3_3() {
    println("Введите положительное число:")
    val number = readLine()!!.toInt()

    var result = number

    // Продолжаем суммировать цифры, пока результат не станет однозначным числом
    while (result >= 10) {
        println("Текущее число: $result")

        // Преобразуем число в строку, чтобы получить отдельные цифры
        val digits = result.toString()
        var sum = 0

        // Суммируем все цифры
        for (digitChar in digits) {
            val digit = digitChar.toString().toInt()
            sum += digit
        }

        result = sum
        println("Сумма цифр: $sum")
    }

    println("Окончательный результат: $result")
}

fun Lesson3_4() {
        println("Введите высоту лесенки:")
        val height = readLine()!!.toInt()

        for (i in height downTo 1) {
            // Печатаем i символов '#' в каждой строке
            for (j in 1..i) {
                print("#")
            }
            // Переходим на новую строку после каждой строки с решетками
            println()
        }
    }
package lesson5

fun main() {
    println("КОНВЕРТЕР ТЕКСТА В ASCII")

    print("Введите текст: ")
    val inputText = readln()

    println()
    println("Результат преобразования:")

    val codes = mutableListOf<Int>()
    for (char in inputText) {
        val code = char.code
        codes.add(code)
        print("$code ")
    }

    println("\n")
    println("Итоговая последовательность: ${codes.joinToString(" ")}")

    println("\n" + "=".repeat(50))
    convertAsciiToText()
}

fun convertAsciiToText() {
    println("ПРЕОБРАЗОВАНИЕ ASCII-КОДОВ В ТЕКСТ")


    print("Введите ASCII-коды через пробел: ")
    val inputCodes = readln()


    val codeStrings = inputCodes.split(" ")
    println("Нашли коды: $codeStrings")

    // Создаем переменную для результата
    var resultText = ""

    // Преобразуем каждый код в символ
    println("\nПреобразуем коды в символы:")

    for (codeStr in codeStrings) {
        if (codeStr.isNotEmpty()) { // Пропускаем пустые строки
            try {
                // Преобразуем строку в число
                val code = codeStr.toInt()

                // Преобразуем число в символ
                val char = code.toChar()

                // Добавляем символ к результату
                resultText += char

                // Показываем процесс
                println("Код $code → Символ '$char'")
            } catch (e: NumberFormatException) {
                println("Ошибка: '$codeStr' не является числом!")
            }
        }
    }

    println("\nРЕЗУЛЬТАТ")
    println("Восстановленный текст: \"$resultText\"")
}
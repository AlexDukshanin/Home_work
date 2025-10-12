package lesson12

//Дан список слов. Нужно сгруппировать слова, которые являются
//анаграммами.
//{"listen", "silent", "enlist", "java", "avaj", "world"}

fun groupAnagrams(words: Array<String>): List<List<String>> {
    val anagramGroups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        // Сортируем буквы в слове чтобы получить ключ анаграммы
        val sortedWord = word.toCharArray().sorted().joinToString("")

        // Добавляем слово в соответствующую группу
        anagramGroups.getOrPut(sortedWord) { mutableListOf() }.add(word)
    }

    return anagramGroups.values.toList()
}

fun main() {
    val words = arrayOf("listen", "silent", "enlist", "java", "avaj", "world")
    val result = groupAnagrams(words)

    println("Группы анаграмм:")
    result.forEachIndexed { index, group ->
        println("${index + 1}. ${group.joinToString(", ")}")
    }
}




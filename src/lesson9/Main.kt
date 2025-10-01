package lesson9

fun main() {
    println("=== ТЕКСТОВАЯ RPG ИГРА ===")

    // Создание героев
    val hero1 = Hero("PALADIN", health = 100, criticalAttacks = 3)
    val hero2 = Hero("ROGUE", health = 100, criticalAttacks = 3)

    // Создание игрового поля и запуск игры
    val game = GameField(hero1, hero2)
    game.startGame()

    // Возможность реванша
    println("\nХотите сыграть реванш? (да/нет): ")
    val rematch = readln().lowercase()
    if (rematch == "д" || rematch == "y" || rematch == "Д" || rematch == "Y") {
        val newHero1 = Hero("PALADIN", health = 100, criticalAttacks = 3)
        val newHero2 = Hero("ROGUE", health = 100, criticalAttacks = 3)
        val newGame = GameField(newHero1, newHero2)
        newGame.startGame()
    }
}
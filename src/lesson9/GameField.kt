package lesson9

import Dice


class GameField(
    private val player1: Hero,
    private val player2: Hero,
    private val dice: Dice = Dice(),
    private var maxDistance: Int = 12
) {
    private var currentPlayer: Hero = player1
    private var opponent: Hero = player2
    private var round: Int = 1

    init {
        // Начальные позиции игроков
        player1.position = 0
        player2.position = maxDistance
        println("🎮 ИГРА НАЧИНАЕТСЯ!")
        println("$player1 vs $player2")
        println("Расстояние между игроками: ${getDistance()}")
        println()
    }

    private fun getDistance(): Int = player2.position - player1.position

    private fun switchPlayers() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
        opponent = if (currentPlayer == player1) player2 else player1
    }

    private fun showGameState() {
        println("\n=== РАУНД $round ===")
        println("Ходит: ${currentPlayer.name}")
        println("Дистанция: ${getDistance()} единиц")
        println("$player1")
        println("$player2")
        println()
    }

    private fun handleMovement(): Boolean {
        if (getDistance() <= 1) {
            println("Игроки уже находятся в ближнем бою!")
            return true
        }

        print("Хотите сделать шаг вперед? (да/нет): ")
        val response = readln().lowercase()

        if (response == "д" || response == "y" || response == "Д" || response == "Y") {
            val maxSteps = "3"
            print("Сколько шагов сделать? (1-$maxSteps): ")
            val steps = readln().toIntOrNull() ?: 0

            if (steps in 1..currentPlayer.maxSteps) {
                currentPlayer.move(steps)

                // Проверяем, достигли ли противника
                if (getDistance() <= 1) {
                    println("🎯 ${currentPlayer.name} достиг противника! Можно атаковать!")
                    return true
                }
            } else {
                println("Неверное количество шагов!")
            }
        }
        return getDistance() <= 1
    }

    private fun handleAttack(): Int {
        var baseDamage = dice.roll()
        var damageType = "обычная"

        // Проверка на критический промах (1 на кубике)
        if (baseDamage == 1) {
            println("💫 КРИТИЧЕСКИЙ ПРОМАХ! Урон: 0")
            return 0
        }

        // Предложение использовать критическую атаку
        if (currentPlayer.criticalAttacks > 0) {
            print("Использовать критическую атаку? (осталось: ${currentPlayer.criticalAttacks}) (да/нет): ")
            val useCritical = readln().lowercase()

            if (useCritical == "д" || useCritical == "y" || useCritical == "Д" || useCritical == "Y"){
                if (currentPlayer.useCriticalAttack()) {
                    baseDamage *= 2
                    damageType = "КРИТИЧЕСКАЯ"
                    println("🔥 АКТИВИРОВАНА КРИТИЧЕСКАЯ АТАКА!")
                }
            }
        }

        // Проверка на блокировку (выпадение 6 у противника)
        val opponentRoll = dice.roll()
        if (opponentRoll == 6) {
            println("🛡️ ${opponent.name} полностью блокирует урон! (выпало: 6)")
            return 0
        }

        // Проверка на обычный критический удар (6 на кубике)
        if (baseDamage == 6 && damageType != "КРИТИЧЕСКАЯ") {
            baseDamage *= 2
            damageType = "критическая"
            println("🎯 Критический удар! (выпало: 6)")
        }

        println("$damageType атака! Урон: $baseDamage (выпало: ${if (damageType == "КРИТИЧЕСКАЯ") baseDamage/2 else baseDamage})")
        return baseDamage
    }
    fun startGame() {
        while (player1.isAlive && player2.isAlive) {
            showGameState()

            // Фаза движения
            val canAttack = handleMovement()

            // Фаза атаки (только если игроки рядом)
            if (canAttack) {
                val damage = handleAttack()
                if (damage > 0) {
                    opponent.takeDamage(damage)
                    println("💥 ${opponent.name} получает $damage урона! Осталось здоровья: ${opponent.health}")
                }
            } else {
                println("📏 Слишком большое расстояние для атаки!")
            }

            // Проверка конца игры
            if (!opponent.isAlive) {
                println("\n🎉 ПОБЕДА! ${currentPlayer.name} побеждает!")
                break
            }

            // Смена игрока и увеличение раунда
            switchPlayers()
            if (currentPlayer == player1) round++

            println("\n" + "─".repeat(50))
        }

        println("\n=== ИГРА ОКОНЧЕНА ===")
        println("Финальный результат:")
        println(player1)
        println(player2)
    }
}
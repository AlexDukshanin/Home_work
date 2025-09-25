package lesson9

class Hero(
    val name: String,
    var health: Int = 100,
    var position: Int = 0,
    var criticalAttacks: Int = 3, // Ограниченное количество критических атак
    val maxSteps: Int = 3 // Максимальное количество шагов за ход
) {
    var isAlive: Boolean = false
        get() = health > 0

    fun takeDamage(damage: Int) {
        health -= damage
        if (health <= 0) {
            health = 0
            isAlive = false
        }
    }

    fun move(steps: Int) {
        if (steps in 1..maxSteps) {
            position += steps
            println("$name делает $steps шагов вперед. Текущая позиция: $position")
        } else {
            println("Неверное количество шагов! Максимум $maxSteps шагов за ход.")
        }
    }

    fun useCriticalAttack(): Boolean {
        if (criticalAttacks > 0) {
            criticalAttacks--
            return true
        }
        return false
    }

    override fun toString(): String = "$name (❤️$health, 🎯$criticalAttacks, 📍$position)"
}
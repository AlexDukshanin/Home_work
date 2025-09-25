import kotlin.random.Random


class Dice(private val sides: Int = 6) {
    fun roll(): Int = Random.nextInt(1, sides + 1)

}
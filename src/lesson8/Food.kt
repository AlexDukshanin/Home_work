package lesson8

class Food (
    override val name: String,
    override val price: Double,
) : Product  {
    override fun getFinalPrice(): Double {
        return price
    }

    override fun toString(): String = "Еда: $name - $price"
}
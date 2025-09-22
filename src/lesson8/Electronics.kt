package lesson8

class Electronics(
    override val name: String,
    override val price: Double,
) : Product {
    override fun getFinalPrice(): Double {
        return price *0.9
    }

    override fun toString(): String = "Электроника: $name - $price руб."
}

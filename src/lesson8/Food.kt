package lesson8

class Food (
    override val name: String,
    override val price: Double,
    override val discount: Double,
) : Product  {
    override fun getFinalPrice(): Double {
        return price * (1-discount/100)
    }

    override fun toString(): String = "Еда: $name - $price руб. - Скидка:$discount"
}
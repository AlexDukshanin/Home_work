package lesson8

class Clothing (
    override val name: String,
    override val price: Double,
    override val discount: Double,
) : Product {
    override fun getFinalPrice(): Double {
        return price * (1-discount/100)
    }

    override fun toString(): String = "Одежда: $name - $price руб. - Скидка:$discount"
}
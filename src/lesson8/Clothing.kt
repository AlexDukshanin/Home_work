package lesson8

class Clothing (
    override val name: String,
    override val price: Double,
    val discount: Double
) : Product {
    override fun getFinalPrice(): Double {
        return price *0.85
    }

    override fun toString(): String = "Одежда: $name - $price"
}
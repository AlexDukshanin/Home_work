package lesson8

interface Product {
    val name: String
    val price: Double
    val discount: Double
    fun getFinalPrice():Double
}
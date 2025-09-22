package lesson8

fun main() {
    val products = listOf<Product>(
        Electronics("Смартфон", 50000.0),
        Clothing("Куртка", 10000.0),
        Food("Хлеб", 50.0)
    )
    println("=== КАТАЛОГ ТОВАРОВ ===")
    println()

    for (product in products) {
        val finalPrice = product.getFinalPrice()
        println("${product}")
        println("   Итоговая цена: ${"%.2f".format(finalPrice)} руб.")
    }
}
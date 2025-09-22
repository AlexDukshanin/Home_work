package lesson8

fun main() {
    val products = listOf<Product>(
        Electronics("Смартфон", 50000.0, 10.0),
        Clothing("Куртка", 10000.0, 15.0),
        Food("Хлеб", 50.0)
    )
    println("=== КАТАЛОГ ПРОДУКТОВ ===")
    for (product in products) {
        println("${product} -> Итоговая цена: ${"%.2f".format(product.getFinalPrice())} руб.")
    }
}
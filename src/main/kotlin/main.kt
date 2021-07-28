fun main() {

    /** Creating a Pizza Store */
    val pizzaStore: PizzaStore = NewYorkPizzaStore()

    /** Ordering a New York style cheese and chicken pizza  */
    val cheesePizza: Pizza? = pizzaStore.orderPizza("cheese")
    val chickenPizza: Pizza? = pizzaStore.orderPizza("chicken")

    println("Order 1 - Pizza: ${cheesePizza?.name}")
    println("Order 2 - Pizza: ${chickenPizza?.name}")

}
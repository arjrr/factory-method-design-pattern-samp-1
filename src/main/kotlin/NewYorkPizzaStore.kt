class NewYorkPizzaStore : PizzaStore() {
    override fun createPizza(item: String): Pizza? {
        when (item) {
            "cheese" -> return NewYorkStyleCheesePizza()
            "chicken" -> return NewYorkStyleChickenPizza()
        }
        return null
    }
}
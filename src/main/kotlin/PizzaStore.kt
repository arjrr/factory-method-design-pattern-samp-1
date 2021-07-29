abstract class PizzaStore {

    /** Factory method  */
    protected abstract fun createPizza(item: String): Pizza?

    fun orderPizza(type: String): Pizza? {
        val pizza = createPizza(type)
        println("--- Making a ${pizza?.name} ---")
        return pizza
    }

}
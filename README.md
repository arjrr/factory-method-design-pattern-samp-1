## Factory Method (_Design Pattern_)

Exemplo de implementação do padrão de projeto _Factory Method_.

Linguagem: Kotlin

## Definição

Segundo Freeman e Freeman (2004):

"**O padrão Factory Method:** Define uma interface para criar um objeto, mas permite às classes decidirem qual classe
instanciar. O Factory Method permite a uma classe deferir a instanciação para subclasses."

Diagrama de classe:

<img width="600" alt="Screen Shot 2021-04-16 at 16 15 41" src="https://user-images.githubusercontent.com/5003410/127485671-c48482a5-b04b-4fd5-8266-79446622b6f0.png">

<sup>Fonte: https://refactoring.guru/pt-br/design-patterns/factory-method</sup>

## Encapsulando a criação de objetos

O padrão de projeto Factory Method visa encapsular a criação de objetos de uma classe. Muitas vezes isso está
relacionado à identificação dos aspectos que variam em um projeto, ou seja, a instanciação de diferentes objetos a
partir de determinados parâmetros. Quando falamos em _factory_, dejamos que ele seja responsável pelos detalhes de
criação dos nossos objetos.

## Factory Method na prática

"Como com toda fábrica, o padrão Factory Method oferece um modo de encapsular as instanciações de tipos concretos.
Examinando o diagrama de classes..." (FREEMAN e FREEMAN, 2004)

> "O criador abstrato oferece uma interface com um método para criar objetos, também conhecido como o Factory Method"

> "Qualquer outro método implementado no criador abstrato é escrito para operar em produtos fabricados pelo Factory Method"

> "Apenas as subclasses realmente implementam o método fábrica e criam produtos"

## O princípio da inversão de dependência

"Dependa de abstrações. Não dependa de classes concretas." (FREEMAN e FREEMAN, 2004)

O princípio da inversão de dependência sugere que componentes de alto nível não dependam de componentes de baixo nível. No exemplo de implementação abaixo podemos considerar PizzaStore como um componente de alto nível e os objetos de Pizza como os de baixo nível.

Segundo Freeman e Freeman (2004), "depois de aplicar o Factory Method você irá notar que nosso componente de alto nível, o PizzaStore, e nossos componentes de baixo nível, as pizzas, dependem de Pizza, a abstração."

"Factory Method não é a única técnica para aderir ao Princípio de Inversão de Dependência, mas é uma das mais eficazes." (FREEMAN e FREEMAN, 2004) 

## Implementação

Criando pizzarias...

**Pizza (Product)**

```kotlin
interface Pizza {
    val name: String
}
```

**NewYorkStyleCheesePizza (Concrete Product)**

```kotlin
class NewYorkStyleCheesePizza : Pizza {
    override val name: String
        get() = "New York Style Sauce and Cheese Pizza"
}
```

**PizzaStore (Creator)**

```kotlin
bstract class PizzaStore {

    /** Factory method  */
    protected abstract fun createPizza(item: String): Pizza?

    fun orderPizza(type: String): Pizza? {
        val pizza = createPizza(type)
        println("--- Making a ${pizza?.name} ---")
        return pizza
    }

}
```

**NewYorkPizzaStore (Concrete PizzaStore)**

```kotlin
class NewYorkPizzaStore : PizzaStore() {
    override fun createPizza(item: String): Pizza? {
        when (item) {
            "cheese" -> return NewYorkStyleCheesePizza()
            "chicken" -> return NewYorkStyleChickenPizza()
        }
        return null
    }
}
```

**Main**

```kotlin
fun main() {

    /** Creating a Pizza Store */
    val pizzaStore: PizzaStore = NewYorkPizzaStore()

    /** Ordering a New York style cheese and chicken pizza  */
    val cheesePizza: Pizza? = pizzaStore.orderPizza("cheese")
    val chickenPizza: Pizza? = pizzaStore.orderPizza("chicken")

    println("Order 1 - Pizza: ${cheesePizza?.name}")
    println("Order 2 - Pizza: ${chickenPizza?.name}")

}
```

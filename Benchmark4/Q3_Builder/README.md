# Builder · Pizza orders

Builder lets a caller configure a product a step at a time and obtain the
finished object when the order is ready.

`Pizza` is the supplied model. Work through the TODOs in `PizzaBuilder` and
use `BuilderDriver` to see how the caller configures two orders. Every order
starts with a size. Each of the four toppings is optional and starts off.

## Read about Builder

- [Baeldung · Implement the Builder Pattern in Java](https://www.baeldung.com/java-builder-pattern-)
- [GeeksforGeeks · Builder Design Pattern](https://www.geeksforgeeks.org/system-design/builder-design-pattern/)
- [Refactoring.Guru · Builder](https://refactoring.guru/design-patterns/builder)

Run `./gradlew runBuilder` and `./gradlew test --tests '*BuilderTest'`.

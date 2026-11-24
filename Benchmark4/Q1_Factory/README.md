# Factory Method · Computer shop

Factory Method puts product creation behind a shared operation. Each concrete
factory decides which product to make.

The shop needs to fill orders for Windows computers and Macs. Read the supplied
`IComputer`, `Windows`, and `Mac` models, then finish the scenario in
`FactoryDriver`. Use one factory variable to handle both orders and pass each
model number through to the computer being made.

The driver and tests use `IComputerFactory` (an interface),
`WindowsFactory`, and `MacFactory` in the `Factories` package. The shared
operation is `IComputer makeComputer(String modelNumber)`.

Run `./gradlew runFactory` to see the shop fill both orders. Use
`./gradlew test --tests '*FactoryTest'` to check this exercise.

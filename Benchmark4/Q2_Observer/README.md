# Observer · Color displays

Observer lets a subject send updates to the objects currently subscribed to
it through a common callback.

A `Color` can have a hex display, an RGB display, or both. Creating a display
for a `Color` subscribes it to that subject. A display that has been removed
stays silent until it is added again. Use the supplied `Colors` values and
`ColorConvertersUtil` to format the updates.

Start with `Color` and `AbsObserver`. The tests expect an abstract
`AbsObserver` with a `void update(Colors color)` callback, plus `HexObserver`
and `RGBObserver` in `Observers`. Each concrete display takes a `Color` when
created. The sample sessions in `ObserverDriver` show the output labels.

Run `./gradlew runObserver` after finishing the demo and
`./gradlew test --tests '*ObserverTest'` to check this exercise.

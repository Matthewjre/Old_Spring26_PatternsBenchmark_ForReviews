package Q3_Builder;

import Q3_Builder.Builder.PizzaBuilder;
import Q3_Builder.Models.Pizza;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static testsupport.Checks.consoleLines;

class BuilderTest {
    @Test
    void plainOrderHasItsRequestedSizeAndNoToppings() {
        Pizza plain = new PizzaBuilder("Small").build();
        assertEquals(List.of("Pizza size: Small", "Cheese: false", "Pepperoni: false",
                "Mushrooms: false", "Olives: false"), consoleLines(plain::showPizza));
    }

    @Test
    void separateOrdersKeepTheirOwnToppings() {
        Pizza first = new PizzaBuilder("Large").addCheese().addOlives().build();
        Pizza second = new PizzaBuilder("Medium").addPepperoni().addMushrooms().build();
        Pizza third = new PizzaBuilder("Small").addCheese().addMushrooms().build();

        assertEquals(List.of("Pizza size: Large", "Cheese: true", "Pepperoni: false",
                "Mushrooms: false", "Olives: true"), consoleLines(first::showPizza));
        assertEquals(List.of("Pizza size: Medium", "Cheese: false", "Pepperoni: true",
                "Mushrooms: true", "Olives: false"), consoleLines(second::showPizza));
        assertEquals(List.of("Pizza size: Small", "Cheese: true", "Pepperoni: false",
                "Mushrooms: true", "Olives: false"), consoleLines(third::showPizza));
    }
}

package Q3_Builder;

import Q3_Builder.Builder.PizzaBuilder;
import Q3_Builder.Models.Pizza;

public class BuilderDriver {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder("Large")
                .addCheese()
                .addPepperoni()
                .build();

        System.out.println("First Pizza:");
        pizza.showPizza();

        Pizza secondPizza = new PizzaBuilder("Medium")
                .addCheese()
                .addPepperoni()
                .addMushrooms()
                .addOlives()
                .build();

        System.out.println("\nSecond Pizza:");
        secondPizza.showPizza();
    }
}

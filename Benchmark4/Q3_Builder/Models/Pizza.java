package Q3_Builder.Models;

public class Pizza
{
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean olives;

    public Pizza(String size, boolean cheese, boolean pepperoni,
                 boolean mushrooms, boolean olives) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
        this.olives = olives;
    }

    public void showPizza() {
        System.out.println("Pizza size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Mushrooms: " + mushrooms);
        System.out.println("Olives: " + olives);
    }
}
package org.example.project4_software;
/**
 * Factory class for creating Chicago-style pizzas.
 * Each method creates a specific pizza type and initializes it with
 * the correct crust and toppings based on Chicago-style recipes.
 *
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class ChicagoPizza implements PizzaFactory {
    /**
     * Creates a Chicago-style Deluxe pizza with its predefined toppings.
     *
     * @return a Deluxe pizza object with Chicago-style crust and toppings
     */
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.ChicagoDeluxe);
        pizza.setType("Chicago");
        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.greenpepper);
        pizza.addTopping(Topping.onion);
        pizza.addTopping(Topping.mushroom);
        return pizza;
    }
    /**
     * Creates a Chicago-style Meatzza pizza with its predefined toppings.
     *
     * @return a Meatzza pizza object with Chicago-style crust and toppings
     */
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.ChicagoMeatzza);
        pizza.setType("Chicago");
        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.beef);
        pizza.addTopping(Topping.ham);
        return pizza;
    }
    /**
     * Creates a Chicago-style BBQ Chicken pizza with its predefined toppings.
     *
     * @return a BBQChicken pizza object with Chicago-style crust and toppings
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.ChicagoBBQChicken);
        pizza.setType("Chicago");
        pizza.addTopping(Topping.BBQChicken);
        pizza.addTopping(Topping.greenpepper);
        pizza.addTopping(Topping.provolone);
        pizza.addTopping(Topping.cheddar);
        return pizza;
    }
    /**
     * Creates a Chicago-style Build Your Own pizza.
     * This pizza starts with no toppings and allows user customization.
     *
     * @return a BuildYourOwn pizza object with Chicago-style crust
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.ChicagoBYO);
        pizza.setType("Chicago");
        return pizza;
    }
}

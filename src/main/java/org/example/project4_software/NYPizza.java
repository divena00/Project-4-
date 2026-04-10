package org.example.project4_software;
/**
 * Factory class for creating New York-style pizzas.
 * This class implements the PizzaFactory interface and is responsible
 * for creating different types of pizzas with New York-style crusts
 * and predefined toppings.
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class NYPizza implements PizzaFactory {
    /**
     * Creates a New York-style Deluxe pizza with its predefined toppings.
     *
     * @return a Deluxe pizza object with New York-style crust and toppings
     */
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.NYDeluxe);
        pizza.setType("NY");

        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.greenpepper);
        pizza.addTopping(Topping.onion);
        pizza.addTopping(Topping.mushroom);

        return pizza;
    }
    /**
     * Creates a New York-style Meatzza pizza with its predefined toppings.
     *
     * @return a Meatzza pizza object with New York-style crust and toppings
     */
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.NYMeatzza);
        pizza.setType("NY");

        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.beef);
        pizza.addTopping(Topping.ham);

        return pizza;
    }
    /**
     * Creates a New York-style BBQ Chicken pizza with its predefined toppings.
     *
     * @return a BBQChicken pizza object with New York-style crust and toppings
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.NYBBQChicken);
        pizza.setType("NY");

        pizza.addTopping(Topping.BBQChicken);
        pizza.addTopping(Topping.greenpepper);
        pizza.addTopping(Topping.provolone);
        pizza.addTopping(Topping.cheddar);

        return pizza;
    }
    /**
     * Creates a New York-style Build Your Own pizza.
     * This pizza starts with no toppings and allows user customization.
     *
     * @return a BuildYourOwn pizza object with New York-style crust
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.NYBYO);
        pizza.setType("NY");
        return pizza;
    }
}

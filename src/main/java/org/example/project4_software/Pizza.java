package org.example.project4_software;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Abstract class representing a pizza.
 * Contains common properties such as toppings, crust, size,
 * and style, and defines shared behavior for all pizza types.
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    private String type;
    /**
     * abstract method for the price
     * @return
     */
    public abstract double price();
    /**
     * pizza object constructor
     */
    Pizza() {
        toppings = new ArrayList<>();
        size = Size.small;
        crust = null;
    }
    /**
     * Sets the pizza style (Chicago or New York).
     *
     * @param pizza style string
     */
    public void setType(String pizza) {
        if (pizza.equalsIgnoreCase("NY")) {
            type = "New York Style";
        } else if (pizza.equalsIgnoreCase("Chicago")) {
            type = "Chicago Style";
        }
    }
    /**
     * Builds a formatted string of toppings.
     *
     * @return comma-separated toppings
     */
    private String toStringToppings() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < toppings.size(); i++) {
            x.append(toppings.get(i));
            if (i < toppings.size() - 1) {
                x.append(", ");
            }
        }
        return x.toString();
    }
    /**
     * Returns a string representation of the pizza,
     * including style, crust, toppings, size, and price.
     *
     * @return formatted pizza description
     */
    @Override
    public String toString() {
        return "(" + type + "-" + Crust.crustInfo(crust) + ")" +
                toStringToppings() + " " +
                size.toString().toUpperCase(Locale.ROOT) + " " +
                price();
    }
    /**
     * Adds a topping to the pizza.
     * Limits Build Your Own pizzas to 5 toppings.
     *
     * @param topping topping to add
     * @return true if added, false otherwise
     */
    public boolean addTopping(Topping topping) {
        if (topping == null) {
            return false;
        }
        if (toppings.contains(topping)) {
            return false;
        }
        if (this instanceof BuildYourOwn && toppings.size() >= 5) {
            return false;
        }
        toppings.add(topping);
        return true;
    }

    /**
     * Removes a topping from the pizza.
     *
     * @param topping topping to remove
     * @return true if removed, false otherwise
     */
    public boolean removeTopping(Topping topping) {
        return toppings.remove(topping);
    }
    /**
     * Gets the number of toppings on the pizza.
     *
     * @return number of toppings
     */
    public int sizeToppings() {
        return toppings.size();
    }
    /**
     * Gets the size of the pizza.
     *
     * @return pizza size
     */
    public Size getSize() {
        return size;
    }
    /**
     * Sets the size of the pizza.
     *
     * @param size pizza size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Sets the crust of the pizza.
     *
     * @param crust crust type
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }
    /**
     * Gets the crust of the pizza.
     *
     * @return crust type
     */
    public Crust getCrust() {
        return crust;
    }
    /**
     * Gets the list of toppings.
     *
     * @return list of toppings
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}

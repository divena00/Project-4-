package org.example.project4_software;

import java.util.ArrayList;
/**
 * Represents a customer's order.
 * Stores a list of pizzas, calculates subtotal, tax, and total,
 * and assigns a unique order number.
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class Order{
    private int orderNum;
    private int pizzaNum;
    private static final double NJ_TAX_RATE = 0.06625;
    private ArrayList<Pizza> pizzaOrder;
    private static int count = 1;
    /**
     * Constructs a new Order with a unique order number.
     */
    public Order(){
        this.orderNum = count++;
        this.pizzaOrder = new ArrayList<Pizza>();
    }
    /**
     * Returns a string representation of all pizzas in the order.
     *
     * @return formatted string of pizzas
     */
    public String toString(){
        String y = "";
        for(Pizza pizza: pizzaOrder){
            y += pizza + "\n";
        }
        return y;
    }
    /**
     * Gets the order number.
     *
     * @return order number
     */
    public int getOrderNum(){
        return this.orderNum;
    }
    /**
     * Gets the list of pizzas in the order.
     *
     * @return list of pizzas
     */
    public ArrayList<Pizza> getPizzaOrder(){
        return this.pizzaOrder;
    }
    /**
     * Adds a pizza to the order.
     *
     * @param pizza the pizza to add
     * @return true if added, false if null
     */
    public boolean addPizza(Pizza pizza) {
        if (pizza == null) {
            return false;
        }
        pizzaOrder.add(pizza);
        return true;
    }
    /**
     * Removes a pizza from the order.
     *
     * @param pizza the pizza to remove
     * @return true if removed, false otherwise
     */
    public boolean removePizza(Pizza pizza) {
        return pizzaOrder.remove(pizza);
    }
    public Pizza PizzaSearch(Pizza found){
        for(Pizza pizza:pizzaOrder){
            if(pizza.equals(found)){
                return pizza;
            }
        }
        return null;
    }
    /**
     * Calculates the subtotal of the order.
     *
     * @return subtotal price
     */
    public double getSubtotal(){
        double price = 0.0;
        for(Pizza pp: pizzaOrder){
            price += pp.price();
        }
        return price;
    }
    /**
     * Calculates the sales tax based on subtotal.
     *
     * @return tax amount
     */
    public double getTaxRate(){
        return (getSubtotal() * NJ_TAX_RATE);
    }
    /**
     * Calculates the total cost including tax.
     *
     * @return total price
     */
    public double getTotal(){
        if(pizzaOrder.isEmpty()){
            return 0;
        }
        return (this.getSubtotal() + getTaxRate());
    }
    /**
     * Gets the tax amount.
     *
     * @return tax value
     */
    public double getTax() {
        return getSubtotal() * NJ_TAX_RATE;
    }
}

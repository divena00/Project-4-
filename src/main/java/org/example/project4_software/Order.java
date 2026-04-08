package org.example.project4_software;

import java.util.ArrayList;

public class Order{
    private int orderNum;
    private int pizzaNum;
    private static final double NJ_TAX_RATE = 0.06625;
    private ArrayList<Pizza> pizzaOrder;
    private static int count = 0;

    public Order(){
        this.orderNum = count++;
        this.pizzaOrder = new ArrayList<Pizza>();
    }
    public String toString(){
        String y = "";
        for(Pizza pizza: pizzaOrder){
            y += pizza + "\n";
        }
        return y;
    }
    public int getOrderNum(){
        return this.orderNum;
    }
    public ArrayList<Pizza> getPizzaOrder(){
        return this.pizzaOrder;
    }
    public boolean addPizza(Pizza pizza) {
        if (pizza == null) {
            return false;
        }
        pizzaOrder.add(pizza);
        return true;
    }
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
    public double getSubtotal(){
        double price = 0.0;
        for(Pizza pp: pizzaOrder){
            price += pp.price();
        }
        return price;
    }
    public double getTaxRate(){
        return (getSubtotal() * NJ_TAX_RATE);
    }
    public double getTotal(){
        if(pizzaOrder.isEmpty()){
            return 0;
        }
        return (this.getSubtotal() + getTaxRate());
    }
}

package org.example.project4_software;

import java.util.ArrayList;
import java.util.Locale;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    private String type;

    public abstract double price();
    Pizza() {
        toppings = new ArrayList<>();
        size = Size.small;
        crust = null;
    }
    public void setType(String pizza) {
        if (pizza.equalsIgnoreCase("NY")) {
            type = "New York Style";
        } else if (pizza.equalsIgnoreCase("Chicago")) {
            type = "Chicago Style";
        }
    }
    private String toStringToppings() {
        String x = "";
        for (Topping topping : toppings) {
            x += topping.toString() + ", ";
        }
        return x;
    }
    @Override
    public String toString() {
        return "(" + type + "-" + Crust.crustInfo(crust) + ")" +
                toStringToppings() + " " +
                size.toString().toUpperCase(Locale.ROOT) + " " +
                price();
    }
    public boolean addTopping(Topping topping) {
        if (toppings.contains(topping)) {
            return false;
        }
        if (toppings.size() >= 5) {
            return false;
        }
        toppings.add(topping);
        return true;
    }
    public boolean removeTopping(Topping topping) {
        return toppings.remove(topping);
    }

    public int sizeToppings() {
        return toppings.size();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Crust getCrust() {
        return crust;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}

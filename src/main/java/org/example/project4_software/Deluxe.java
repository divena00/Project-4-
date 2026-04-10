package org.example.project4_software;
/**
 * Represents a Deluxe pizza.
 * This is a specialty pizza with predefined toppings:
 * sausage, pepperoni, green pepper, onion, and mushroom.
 *
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class Deluxe extends Pizza {
    /**
     * Constructs a Deluxe pizza and initializes it with
     * its default set of toppings.
     */
    Deluxe(){
        addTopping(Topping.sausage);
        addTopping(Topping.pepperoni);
        addTopping(Topping.greenpepper);
        addTopping(Topping.onion);
        addTopping(Topping.mushroom);
    }
    /**
     * Calculates the price of the Deluxe pizza based on size.
     *
     * @return the price of the pizza as a double
     */
    @Override
    public double price(){
        if(super.getSize() == Size.small){
            return 18.99;
        }else if(super.getSize() == Size.medium){
            return 20.99;
        }else if(super.getSize() == Size.large){
            return 22.99;
        }
        return 0;
    }
    /**
     * Returns a string representation of the Deluxe pizza.
     * Includes the pizza name followed by details from the Pizza superclass.
     *
     * @return formatted string describing the pizza
     */
    @Override
    public String toString(){
        return "Deluxe" + super.toString();
    }


}

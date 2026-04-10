package org.example.project4_software;
/**
 * Represents a Meatzza pizza.
 * This is a specialty pizza with predefined toppings:
 * sausage, pepperoni, beef, and ham.
 *
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class Meatzza extends Pizza {
    /**
     * Constructs a Meatzza pizza and initializes it with
     * its default set of toppings.
     */
    Meatzza(){
        addTopping(Topping.sausage);
        addTopping(Topping.pepperoni);
        addTopping(Topping.beef);
        addTopping(Topping.ham);
    }
    /**
     * Returns a string representation of the Meatzza pizza.
     * Includes the pizza name followed by details from the Pizza superclass.
     *
     * @return formatted string describing the pizza
     */
    @Override
    public String toString() {
        return "Meatzza" + super.toString();
    }
    /**
     * Calculates the price of the Meatzza pizza based on size.
     *
     * @return the price of the pizza as a double
     */
    @Override
    public double price(){
        if(super.getSize() == Size.small){
            return 19.99;
        }else if(super.getSize() == Size.medium){
            return 21.99;
        }else if (super.getSize() == Size.large){
            return 23.99;
        }
        return 0;
    }

}

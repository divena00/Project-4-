package org.example.project4_software;
/**
 * Represents a BBQ Chicken pizza.
 * This is a specialty pizza with predefined toppings:
 * BBQ chicken, green pepper, provolone, and cheddar.
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class BBQChicken extends Pizza {
    BBQChicken(){
        addTopping(Topping.BBQChicken);
        addTopping(Topping.greenpepper);
        addTopping(Topping.provolone);
        addTopping(Topping.cheddar);
    }
    /**
     * Returns a string representation of the BBQ Chicken pizza.
     * Includes the pizza name followed by details from the Pizza superclass.
     *
     * @return formatted string describing the pizza
     */
    @Override
    public String toString() {
        return "BBQ Chicken" + super.toString();
    }
    /**
     * Calculates the price of the BBQ Chicken pizza based on size.
     *
     * @return the price of the pizza as a double
     */
    @Override
    public double price(){
        if(super.getSize() == Size.small){
            return 16.99;
        }else if(super.getSize() == Size.medium){
            return 18.99;

        }else if(super.getSize() == Size.large){
            return 20.99;
        }
        return 0;
    }
}

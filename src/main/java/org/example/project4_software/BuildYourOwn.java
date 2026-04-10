package org.example.project4_software;
/**
 * Represents a Build Your Own pizza.
 * This pizza allows the user to customize toppings,
 * with a maximum of 5 toppings allowed.
 * The base price depends on the size, and each topping
 * adds an additional cost of $1.69.
 *
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public class BuildYourOwn extends Pizza {
    /**
     * Constructs a BuildYourOwn pizza with no toppings initially.
     * The user can add or remove toppings through the controller.
     */
    BuildYourOwn(){
    }
    /**
     * Returns a string representation of the Build Your Own pizza.
     * Includes the pizza name followed by details from the Pizza superclass.
     *
     * @return formatted string describing the pizza
     */
    @Override
    public String toString(){
        return "Build Your Own" + super.toString();
    }
    /**
     * Calculates the price of the Build Your Own pizza.
     * The total price is the base price (based on size)
     * plus $1.69 for each selected topping.
     *
     * @return the total price of the pizza as a double
     */
    @Override
    public double price(){
        double extra = (this.sizeToppings() * 1.69);
        if(super.getSize() == Size.small){
            return 10.99 + extra;
        }else if(super.getSize() == Size.medium){
            return 12.99 + extra;
        }else if(super.getSize() == Size.large){
            return 14.99 + extra;
        }
        return 0;
    }

}

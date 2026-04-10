package org.example.project4_software;

import java.util.ArrayList;
/**
 * Enum representing all available pizza toppings.
 * @author Divena Deshmukh
 * @author Ishani Rajeshirke
 */
public enum Topping {
    sausage,
    pepperoni,
    greenpepper,
    onion,
    mushroom,
    BBQChicken,
    provolone,
    cheddar,
    beef,
    ham;
    /**
     * Returns a list of default toppings based on pizza type.
     *
     * This method is used for preset pizzas (Deluxe, BBQ Chicken, Meatzza)
     * to automatically populate their toppings.
     *
     * @param type the type of pizza (e.g., "Deluxe", "BBQ Chicken", "Meatzza")
     * @return an ArrayList of Toppings corresponding to the pizza type
     */
    public static ArrayList<Topping> getTopping(String type){
        ArrayList<Topping> toppings = new ArrayList<>();
        if(type.equalsIgnoreCase("Deluxe")){
            toppings.add(sausage);
            toppings.add(pepperoni);
            toppings.add(greenpepper);
            toppings.add(onion);
            toppings.add(mushroom);
        }else if(type.equalsIgnoreCase(" BBQ Chicken")){
            toppings.add(BBQChicken);
            toppings.add(greenpepper);
            toppings.add(provolone);
            toppings.add(cheddar);
        }else if(type.equalsIgnoreCase("Meatzza")){
            toppings.add(sausage);
            toppings.add(pepperoni);
            toppings.add(beef);
            toppings.add(ham);
        }
        return toppings;
    }
}

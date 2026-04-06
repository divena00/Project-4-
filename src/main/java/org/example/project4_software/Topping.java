package org.example.project4_software;

import java.util.ArrayList;

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

    public static ArrayList<Topping> getToppingd(String type){
        ArrayList<Topping> toppings = new ArrayList<>();
        if(type.equalsIgnoreCase("org.example.project4_software.Deluxe")){
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
        }else if(type.equalsIgnoreCase("org.example.project4_software.Meatzza")){
            toppings.add(sausage);
            toppings.add(pepperoni);
            toppings.add(beef);
            toppings.add(ham);
        }
        return toppings;
    }
}

package org.example.project4_software;

public class Deluxe extends Pizza {
    Deluxe(){
        addTopping(Topping.sausage);
        addTopping(Topping.pepperoni);
        addTopping(Topping.greenpepper);
        addTopping(Topping.onion);
        addTopping(Topping.mushroom);
    }
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
    @Override
    public String toString(){
        return "Deluxe" + super.toString();
    }


}

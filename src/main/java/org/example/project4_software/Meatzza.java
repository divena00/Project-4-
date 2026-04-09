package org.example.project4_software;

public class Meatzza extends Pizza {
    Meatzza(){
        addTopping(Topping.sausage);
        addTopping(Topping.pepperoni);
        addTopping(Topping.beef);
        addTopping(Topping.ham);
    }
    @Override
    public String toString(){
        return "Meatzza" + super.toString();
    }
    public boolean add(Topping topping){
        return false;
    }
    public boolean remove(Topping topping){
        return false;
    }
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

package org.example.project4_software;

public class BBQChicken extends Pizza {
    BBQChicken(){
        addTopping(Topping.BBQChicken);
        addTopping(Topping.greenpepper);
        addTopping(Topping.provolone);
        addTopping(Topping.cheddar);
    }
    @Override
    public String toString(){
        return "BBQ Chicken" + super.toString();
    }
    @Override
    public boolean add(Topping topping){
        return false;
    }
    @Override
    public boolean remove(Topping topping){
        return false;
    }
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

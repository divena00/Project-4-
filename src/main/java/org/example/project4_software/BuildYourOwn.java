package org.example.project4_software;

public class BuildYourOwn extends Pizza {
    BuildYourOwn(){

    }
    @Override
    public String toString(){
        return "Build Your Own" + super.toString();
    }
    public boolean add(Topping topping){
        return false;
    }
    public boolean remove(Topping topping){
        return false;
    }
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

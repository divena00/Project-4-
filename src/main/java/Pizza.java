import java.util.ArrayList;
import java.util.Locale;

public abstract class Pizza {
   private ArrayList<Topping> toppings;
   private Crust crust;
   private Size size;
   public abstract double price();
   private String type;
   Pizza(){
       size = size.small;
       crust = Crust.ChicagoBYO;
   }
   public void setType(String pizza){
       if(pizza.equalsIgnoreCase("NY")){
           type = "New York Style";
       }else if(pizza.equalsIgnoreCase("Chicago")){
           type = "Chicago Style";
       }

   }
    private String toStringToppings(){
        String x = "";
        for ( Topping topping : toppings){
            x += topping.toString() + ", ";
        }
        return x;
    }

    public String toString(){
       return "(" + type + "-" + Crust.crustInfo(crust) + ")" + toStringToppings() + "" + size.toString().toUpperCase(Locale.ROOT) + "" + price();
   }
   public void addTopping(Topping topping){
       toppings.add(topping);
   }
   public void removeTopping(Topping topping){
       toppings.remove(topping);

   }
    public boolean add(Topping topping) {
        if (toppings.contains(topping)) {
            return false;
        }
        if (toppings.size() >= 5) {
            return false;
        }
        toppings.add(topping);
        return true;
    }
    public boolean remove(Topping topping) {
        return toppings.remove(topping);
    }
   public int sizeToppings(){
       return toppings.size();
    }
    public Size getSize(){
       return size;
    }
    public void setSize(){
       this.size = size;
    }
    public void setCrust(Crust crust){
       this.crust = crust;
    }



}

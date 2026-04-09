package org.example.project4_software;

public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.NYDeluxe);
        pizza.setType("NY");
        return pizza;
    }
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.NYMeatzza);
        pizza.setType("NY");
        return pizza;
    }
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.NYBBQChicken);
        pizza.setType("NY");
        return pizza;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.NYBYO);
        pizza.setType("NY");
        return pizza;
    }
}

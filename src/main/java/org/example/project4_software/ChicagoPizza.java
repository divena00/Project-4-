package org.example.project4_software;

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.ChicagoDeluxe);
        pizza.setType("Chicago");
        return pizza;
    }
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.ChicagoMeatzza);
        pizza.setType("Chicago");
        return pizza;
    }
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.ChicagoBBQChicken);
        pizza.setType("Chicago");
        return pizza;
    }
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.ChicagoBYO);
        pizza.setType("Chicago");
        return pizza;
    }
}

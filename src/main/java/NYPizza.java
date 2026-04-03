public class NYPizza implements PizzaFactory {
    private Pizza pizza;

    @Override
    public Pizza createDeluxe(){
        pizza = new Deluxe();
        return pizza;
    }
    @Override
    public Pizza createMeatzza(){
        pizza = new Meatzza();
        return pizza;
    }
    @Override
    public Pizza createBBQChicken(){
        pizza = new BBQChicken();
        return pizza;
    }
    @Override
    public Pizza createBuildYourOwn(){
        pizza = new BuildYourOwn();
        return pizza;
    }


}

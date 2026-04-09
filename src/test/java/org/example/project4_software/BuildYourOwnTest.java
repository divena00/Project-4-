package org.example.project4_software;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BuildYourOwnTest {

    private static final double DELTA = 0.01;

    @Test
    public void testSmallNoToppings() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.small);
        assertEquals(10.99, pizza.price(), DELTA);
    }
    @Test
    public void testSmallFiveToppings() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.small);
        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.beef);
        pizza.addTopping(Topping.mushroom);
        pizza.addTopping(Topping.onion);
        assertEquals(19.44, pizza.price(), DELTA);
    }
    @Test
    public void testMediumNoToppings() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.medium);
        assertEquals(12.99, pizza.price(), DELTA);
    }
    @Test
    public void testMediumThreeToppings() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.medium);
        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.greenpepper);
        pizza.addTopping(Topping.onion);
        assertEquals(18.06, pizza.price(), DELTA);
    }
    @Test
    public void testLargeFiveToppings() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.large);
        pizza.addTopping(Topping.sausage);
        pizza.addTopping(Topping.pepperoni);
        pizza.addTopping(Topping.beef);
        pizza.addTopping(Topping.mushroom);
        pizza.addTopping(Topping.onion);

        // 14.99 + (5 × 1.69) = 23.44
        assertEquals(23.44, pizza.price(), DELTA);
    }
}

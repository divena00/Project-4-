package org.example.project4_software;

public interface PizzaFactory {
    /**
     * creates org.example.project4_software.Deluxe pizza
     * @return org.example.project4_software.Pizza
     */
    Pizza createDeluxe();

    /**
     * creates org.example.project4_software.Meatzza pizza
     * @return org.example.project4_software.Pizza
     */
    Pizza createMeatzza();

    /**
     * creates BBQ Chicken pizza
     * @return org.example.project4_software.Pizza
     */
    Pizza createBBQChicken();

    /**
     * creates Build Your Own pizza
     * @return org.example.project4_software.Pizza
     */
    Pizza createBuildYourOwn();
}

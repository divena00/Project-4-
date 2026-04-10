package org.example.project4_software;
/**
 * Enum representing all possible pizza crust types.
 *  @author Divena Deshmukh
 *  @author Ishani Rajeshirke
 *
 */
public enum Crust {
    ChicagoDeluxe("Deep Dish"),
    NYDeluxe("Brooklyn"),
    ChicagoBBQChicken("Pan"),
    NYBBQChicken("Thin"),
    ChicagoMeatzza("Stuffed"),
    NYMeatzza("Hand-tossed"),
    ChicagoBYO("Pan"),
    NYBYO("Hand-tossed");
    /** Readable crust description (e.g., "Deep Dish", "Thin") */
    private final String crust;
    /**
     * Constructs a Crust enum with a display string.
     *
     * @param crust the human-readable crust description
     */
    Crust(String crust) {
        this.crust = crust;
    }
    /**
     * Returns the display string for a given crust.
     *
     * @param crust the Crust enum value
     * @return the corresponding crust description
     */
    public static String crustInfo(Crust crust) {
        return crust.crust;
    }
    /**
     * Returns the string representation of the crust.
     *
     * @return the crust description
     */
    @Override
    public String toString() {
        return crust;
    }
    /**
     * Determines the correct crust based on pizza type and style.
     *
     * @param pizza the pizza type (e.g., "Deluxe", "Meatzza")
     * @param type  the style ("Chicago" or "New York")
     * @return the corresponding Crust enum value, or null if not found
     */
    public static Crust getCrust(String pizza, String type) {
        if (type.equalsIgnoreCase("New York")) {
            if (pizza.equalsIgnoreCase("Deluxe")) {
                return NYDeluxe;
            } else if (pizza.equalsIgnoreCase("Meatzza")) {
                return NYMeatzza;
            } else if (pizza.equalsIgnoreCase("BBQ Chicken")) {
                return NYBBQChicken;
            } else if (pizza.equalsIgnoreCase("Build Your Own")) {
                return NYBYO;
            }
        } else if (type.equalsIgnoreCase("Chicago")) {
            if (pizza.equalsIgnoreCase("Deluxe")) {
                return ChicagoDeluxe;
            } else if (pizza.equalsIgnoreCase("Meatzza")) {
                return ChicagoMeatzza;
            } else if (pizza.equalsIgnoreCase("BBQ Chicken")) {
                return ChicagoBBQChicken;
            } else if (pizza.equalsIgnoreCase("Build Your Own")) {
                return ChicagoBYO;
            }
        }
        return null;
    }
}

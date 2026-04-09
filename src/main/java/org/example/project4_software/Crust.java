package org.example.project4_software;

public enum Crust {
    ChicagoDeluxe("Deep Dish"),
    NYDeluxe("Brooklyn"),
    ChicagoBBQChicken("Pan"),
    NYBBQChicken("Thin"),
    ChicagoMeatzza("Stuffed"),
    NYMeatzza("Hand-tossed"),
    ChicagoBYO("Pan"),
    NYBYO("Hand-tossed");

    private final String crust;

    Crust(String crust) {
        this.crust = crust;
    }
    public static String crustInfo(Crust crust) {
        return crust.crust;
    }
    @Override
    public String toString() {
        return crust;
    }
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

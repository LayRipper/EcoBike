package base.syntax.model;

public class Speedelec extends EcoBike {

    public Speedelec() {
    }

    public Speedelec(String brand, String maxSpeed, String weight,
                     String lightsAvailability, String batteryCapacity,
                     String color, String price) {
        super(brand, maxSpeed, weight, lightsAvailability, batteryCapacity, color, price);
    }

    public String toString() {
        return "SPEEDELEC "
                + getBrand() + "; "
                + getMaxSpeed() + "; "
                + getWeight() + "; "
                + isLightsAvailable() + "; "
                + getBatteryCapacity() + "; "
                + getColor() + "; "
                + getPrice();
    }
}


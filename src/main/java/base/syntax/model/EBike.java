package base.syntax.model;

public class EBike extends EcoBike {

    public EBike() {
    }

    public EBike(String brand, String maxSpeed, String weight,
                 String lightsAvailability, String batteryCapacity, String color, String price) {
        super(brand, maxSpeed, weight, lightsAvailability, batteryCapacity, color, price);
    }

    @Override
    public String toString() {
        return "E-BIKE "
                + getBrand() + "; "
                + getMaxSpeed() + "; "
                + getWeight() + "; "
                + isLightsAvailable() + "; "
                + getBatteryCapacity() + "; "
                + getColor() + "; "
                + getPrice();
    }
}

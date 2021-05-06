package base.syntax.model;

public class EcoBike extends Bike {
    private String maxSpeed;
    private String batteryCapacity;

    public EcoBike() {
    }

    public EcoBike(String brand, String maxSpeed,
                   String weight, String lightsAvailability,
                   String batteryCapacity, String color, String price) {
        super(brand, weight, lightsAvailability, color, price);
        this.batteryCapacity = batteryCapacity;
        this.maxSpeed = maxSpeed;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}

package base.syntax.model;

import java.util.Objects;

public abstract class Bike {
    private String brand;
    private String weight;
    private String lightsAvailable;
    private String color;
    private String price;

    public Bike() {
    }

    public Bike(String brand, String weight, String lightsAvailability, String color,
            String price) {
        this.brand = brand;
        this.weight = weight;
        this.lightsAvailable = lightsAvailability;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String isLightsAvailable() {
        return lightsAvailable;
    }

    public void setLightsAvailable(String lightsAvailable) {
        this.lightsAvailable = lightsAvailable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bike bike = (Bike) o;
        return Objects.equals(getBrand(), bike.getBrand()) && Objects.equals(getWeight(),
                bike.getWeight()) && Objects.equals(lightsAvailable, bike.lightsAvailable)
                && Objects.equals(getColor(), bike.getColor()) && Objects.equals(getPrice(),
                bike.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getWeight(), lightsAvailable, getColor(), getPrice());
    }
}


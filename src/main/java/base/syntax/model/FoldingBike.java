package base.syntax.model;

public class FoldingBike extends Bike {
    private String wheelSize;
    private String gearsNumber;

    public FoldingBike() {
    }

    public FoldingBike(String brand, String wheelSize,
                       String gearsNumber, String weight,
                       String lightsAvailability, String color, String price) {
        super(brand, weight, lightsAvailability, color, price);
        this.wheelSize = wheelSize;
        this.gearsNumber = gearsNumber;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(String gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    @Override
    public String toString() {
        return "FOLDING BIKE "
                + getBrand() + "; "
                + wheelSize + "; "
                + gearsNumber + "; "
                + getWeight() + "; "
                + isLightsAvailable() + "; "
                + getColor() + "; "
                + getPrice();
    }
}

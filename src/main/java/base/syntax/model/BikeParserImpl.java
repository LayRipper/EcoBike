package base.syntax.model;

public class BikeParserImpl implements BikeParser {
    private static final int BIKE_TYPE_POSITION = 0;
    private static final int WHEEL_SIZE_POSITION = 1;
    private static final int GEARS_NUMBER_POSITION = 2;
    private static final int BIKE_WEIGHT_POSITION = 3;
    private static final int LIGHTS_AVAILABILITY_POSITION = 4;
    private static final int COLOR_POSITION = 5;
    private static final int PRICE_POSITION = 6;
    private static final int EBIKE_MAX_SPEED_POSITION = 1;
    private static final int EBIKE_WEIGHT_POSITION = 2;
    private static final int EBIKE_LIGHTS_AVAILABILITY_POSITION = 3;
    private static final int EBIKE_BATTERY_CAPACITY_POSITION = 4;

    @Override
    public Bike parseBike(String stringBike) {
        String[] bikeSpecs = stringBike.split(";");
        String[] bikeBrandType = bikeSpecs[BIKE_TYPE_POSITION].split(" ");
        return bikeSpecs[BIKE_TYPE_POSITION].contains("FOLDING")
                ? new FoldingBike(bikeBrandType[2],
                        bikeSpecs[WHEEL_SIZE_POSITION], bikeSpecs[GEARS_NUMBER_POSITION],
                        bikeSpecs[BIKE_WEIGHT_POSITION], bikeSpecs[LIGHTS_AVAILABILITY_POSITION],
                        bikeSpecs[COLOR_POSITION], bikeSpecs[PRICE_POSITION])
                : bikeSpecs[BIKE_TYPE_POSITION].contains("E-BIKE")
                ? new EBike(bikeBrandType[1],
                        bikeSpecs[EBIKE_MAX_SPEED_POSITION], bikeSpecs[EBIKE_WEIGHT_POSITION],
                        bikeSpecs[EBIKE_LIGHTS_AVAILABILITY_POSITION],
                        bikeSpecs[EBIKE_BATTERY_CAPACITY_POSITION],
                        bikeSpecs[COLOR_POSITION], bikeSpecs[PRICE_POSITION])
                : bikeSpecs[BIKE_TYPE_POSITION].contains("SPEEDELEC")
                ? new Speedelec(bikeBrandType[1],
                        bikeSpecs[EBIKE_MAX_SPEED_POSITION], bikeSpecs[EBIKE_WEIGHT_POSITION],
                        bikeSpecs[EBIKE_LIGHTS_AVAILABILITY_POSITION],
                        bikeSpecs[EBIKE_BATTERY_CAPACITY_POSITION],
                        bikeSpecs[COLOR_POSITION], bikeSpecs[PRICE_POSITION])
                : null;
    }
}

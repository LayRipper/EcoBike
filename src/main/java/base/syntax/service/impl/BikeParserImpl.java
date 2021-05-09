package base.syntax.service.impl;

import base.syntax.model.Bike;
import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.service.BikeParser;
import java.util.Arrays;

public class BikeParserImpl implements BikeParser {
    private static final int BIKE_TYPE_POSITION = 0;
    private static final int BIKE_BRAND_POSITION = 2;
    private static final int WHEEL_SIZE_POSITION = 1;
    private static final int GEARS_NUMBER_POSITION = 2;
    private static final int BIKE_WEIGHT_POSITION = 3;
    private static final int LIGHTS_AVAILABILITY_POSITION = 4;
    private static final int COLOR_POSITION = 5;
    private static final int PRICE_POSITION = 6;
    private static final int EBIKE_BRAND_POSITION = 1;
    private static final int EBIKE_MAX_SPEED_POSITION = 1;
    private static final int EBIKE_WEIGHT_POSITION = 2;
    private static final int EBIKE_LIGHTS_AVAILABILITY_POSITION = 3;
    private static final int EBIKE_BATTERY_CAPACITY_POSITION = 4;

    @Override
    public Bike parseBike(String stringBike) {
        if (!stringBike.contains(";") || !stringBike.contains(" ")) {
            System.out.println("The file has incorrect structure. "
                    + "Please enter a file/filepath with valid structure.");
            return new Speedelec();
        }
        String[] bikeSpecs = Arrays.stream(stringBike.split(";")).map(String::trim)
                .toArray(String[]::new);
        String[] bikeBrand = bikeSpecs[BIKE_TYPE_POSITION].split(" ");
        return bikeSpecs[BIKE_TYPE_POSITION].contains("FOLDING") ? new FoldingBike(
                bikeBrand[BIKE_BRAND_POSITION], bikeSpecs[WHEEL_SIZE_POSITION],
                bikeSpecs[GEARS_NUMBER_POSITION], bikeSpecs[BIKE_WEIGHT_POSITION],
                bikeSpecs[LIGHTS_AVAILABILITY_POSITION], bikeSpecs[COLOR_POSITION],
                bikeSpecs[PRICE_POSITION]) : bikeSpecs[BIKE_TYPE_POSITION].contains("E-BIKE")
                ? new EBike(bikeBrand[EBIKE_BRAND_POSITION], bikeSpecs[EBIKE_MAX_SPEED_POSITION],
                bikeSpecs[EBIKE_WEIGHT_POSITION], bikeSpecs[EBIKE_LIGHTS_AVAILABILITY_POSITION],
                bikeSpecs[EBIKE_BATTERY_CAPACITY_POSITION], bikeSpecs[COLOR_POSITION],
                bikeSpecs[PRICE_POSITION]) : bikeSpecs[BIKE_TYPE_POSITION].contains("SPEEDELEC")
                ? new Speedelec(bikeBrand[EBIKE_BRAND_POSITION],
                bikeSpecs[EBIKE_MAX_SPEED_POSITION], bikeSpecs[EBIKE_WEIGHT_POSITION],
                bikeSpecs[EBIKE_LIGHTS_AVAILABILITY_POSITION],
                bikeSpecs[EBIKE_BATTERY_CAPACITY_POSITION], bikeSpecs[COLOR_POSITION],
                bikeSpecs[PRICE_POSITION]) : new Speedelec();
    }
}

package main.menu.options.search;

import java.util.Scanner;
import local.storage.BrandStorage;

public class UserInputReaderImpl implements UserInputReader {
    private static final String OPTION_2 = "2";
    private static final String OPTION_3 = "3";
    private static final String OPTION_4 = "4";
    private static final String OPTION_5 = "5";
    private static final String FOLDING_BIKE = "FOLDING BIKE";
    private static final String SPEEDELEC = "SPEEDELEC";
    private static final String E_BIKE = "E-BIKE";

    public String readFromConsole(String option) {
        String bikeBrand;
        String bikeMaxSpeed = "";
        String bikeWeight = "";
        final String bikeLights;
        String bikeBatteryCapacity = "";
        final String bikeColor;
        final String bikePrice;
        String bikeWheelsSize = "";
        String bikeNumberOfGears = "";
        Scanner scanner = new Scanner(System.in);
        final StringBuilder builder = new StringBuilder();

        System.out.print("Brand of bike: ");
        bikeBrand = scanner.nextLine();
        String bikeType = option.equals(OPTION_2)
                ? FOLDING_BIKE : option.equals(OPTION_3)
                ? SPEEDELEC : option.equals(OPTION_4)
                ? E_BIKE : BrandStorage.getKey(bikeBrand);
        if (option.equals("6")) {
            System.out.print("Bike type: ");
            bikeType = scanner.nextLine();
        }
        if (bikeType.equals(E_BIKE)
                || bikeType.equals(SPEEDELEC)) {
            System.out.print("The maximum speed (in km/h):  ");
            bikeMaxSpeed = scanner.nextLine();
            System.out.print("The weight of the e-bike (in grams): ");
            bikeWeight = scanner.nextLine();
            System.out.print("Battery capacity (in mAh): ");
            bikeBatteryCapacity = scanner.nextLine();
        } else if (bikeType.equals(FOLDING_BIKE)) {
            System.out.print("The size of the wheels (in inch):  ");
            bikeWheelsSize = scanner.nextLine();
            System.out.print("The number of gears: ");
            bikeNumberOfGears = scanner.nextLine();
            System.out.print("The weight of the bike (in grams): ");
            bikeWeight = scanner.nextLine();
        }
        System.out.print("The availability of lights at front and back (true/false): ");
        bikeLights = scanner.nextLine();
        System.out.print("Color: ");
        bikeColor = scanner.nextLine();
        System.out.print("Price: ");
        bikePrice = scanner.nextLine();
        scanner.close();

        return option.equals(OPTION_5)
                ? builder.append(bikeBrand).append("; ")
                        .append(bikeWheelsSize).append("; ")
                        .append(bikeNumberOfGears).append("; ")
                        .append(bikeWeight).append("; ")
                        .append(bikeLights).append("; ")
                        .append(bikeColor).append("; ")
                        .append(bikePrice).toString()
                : bikeType.equals(E_BIKE) || bikeType.equals(SPEEDELEC)
                ? builder.append(bikeType).append(" ")
                        .append(bikeBrand).append("; ")
                        .append(bikeMaxSpeed).append("; ")
                        .append(bikeWeight).append("; ")
                        .append(bikeLights).append("; ")
                        .append(bikeBatteryCapacity).append("; ")
                        .append(bikeColor).append("; ")
                        .append(bikePrice).toString()
                : bikeType.equals(FOLDING_BIKE)
                ? builder.append(bikeType).append(" ")
                        .append(bikeBrand).append("; ")
                        .append(bikeWheelsSize).append("; ")
                        .append(bikeNumberOfGears).append("; ")
                        .append(bikeWeight).append("; ")
                        .append(bikeLights).append("; ")
                        .append(bikeColor).append("; ")
                        .append(bikePrice).toString()
                : "Invalid input";
    }
}

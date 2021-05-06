package base.syntax.service;

import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.storage.BrandStorage;
import java.util.Scanner;

public class UserInputReaderImpl implements UserInputReader {
    private static final String OPTION_2 = "2";
    private static final String OPTION_3 = "3";
    private static final String OPTION_4 = "4";
    private static final String OPTION_6 = "6";
    private static final String FOLDING_BIKE = "FOLDING BIKE";
    private static final String SPEEDELEC = "SPEEDELEC";
    private static final String E_BIKE = "E-BIKE";
    private String maxSpeed;
    private String weight;
    private String batteryCapacity;
    private String wheelSize;
    private String gearsNumber;

    public String readFromConsole(String option) {
        if (option.equals("1")) {
            return "";
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Brand of bike: ");
        String bikeBrand = scanner.nextLine();
        String bikeType = option.equals(OPTION_2)
                ? FOLDING_BIKE : option.equals(OPTION_3)
                ? SPEEDELEC : option.equals(OPTION_4)
                ? E_BIKE : BrandStorage.getKey(bikeBrand);
        if (option.equals(OPTION_6)) {
            System.out.print("Bike type: ");
            bikeType = scanner.nextLine();
        }
        if (bikeType.equals(E_BIKE) || bikeType.equals(SPEEDELEC)) {
            System.out.print("The maximum speed (in km/h):  ");
            maxSpeed = scanner.nextLine();
            System.out.print("The weight of the e-bike (in grams): ");
            weight = scanner.nextLine();
            System.out.print("Battery capacity (in mAh): ");
            batteryCapacity = scanner.nextLine();
        }
        if (bikeType.equals(FOLDING_BIKE)) {
            System.out.print("The size of the wheels (in inch):  ");
            wheelSize = scanner.nextLine();
            System.out.print("The number of gears: ");
            gearsNumber = scanner.nextLine();
            System.out.print("The weight of the bike (in grams): ");
            weight = scanner.nextLine();

        }
        System.out.print("The availability of lights at front and back (true/false): ");
        final String lights = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Price: ");
        String price = scanner.nextLine();
        scanner.close();

        return bikeType.equals(E_BIKE) ? new EBike(bikeBrand, maxSpeed, weight, lights,
                batteryCapacity, color, price).toString()
                : bikeType.equals(SPEEDELEC) ? new Speedelec(bikeBrand, maxSpeed, weight, lights,
                batteryCapacity, color, price).toString()
                : bikeType.equals(FOLDING_BIKE) ? new FoldingBike(bikeBrand, wheelSize, gearsNumber,
                weight, lights, color, price).toString() : "Invalid input";
    }
}

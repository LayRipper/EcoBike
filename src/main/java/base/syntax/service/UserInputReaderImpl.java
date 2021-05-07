package base.syntax.service;

import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.storage.BrandStorage;
import java.util.Scanner;

public class UserInputReaderImpl implements UserInputReader {
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_7 = 7;
    private String maxSpeed;
    private String weight;
    private String batteryCapacity;
    private String wheelSize;
    private String gearsNumber;

    public String readFromConsole(Integer option) {
        if (option == OPTION_1 || option == OPTION_7) {
            return "";
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Brand of bike: ");
        String bikeBrand = scanner.nextLine();
        String bikeType = option == OPTION_2
                ? "FOLDING BIKE" : option == OPTION_3
                ? "SPEEDELEC" : option == OPTION_4
                ? "E-BIKE" : BrandStorage.getKey(bikeBrand);
        if (bikeType.equals("E-BIKE") || bikeType.equals("SPEEDELEC")) {
            System.out.print("The maximum speed (in km/h):  ");
            maxSpeed = scanner.nextLine();
            System.out.print("The weight of the e-bike (in grams): ");
            weight = scanner.nextLine();
            System.out.print("Battery capacity (in mAh): ");
            batteryCapacity = scanner.nextLine();
        }
        if (bikeType.equals("FOLDING BIKE")) {
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

        return bikeType.equals("E-BIKE") ? new EBike(bikeBrand, maxSpeed, weight, lights,
                batteryCapacity, color, price).toString()
                : bikeType.equals("SPEEDELEC")
                ? new Speedelec(bikeBrand, maxSpeed, weight, lights,
                batteryCapacity, color, price).toString()
                : bikeType.equals("FOLDING BIKE")
                ? new FoldingBike(bikeBrand, wheelSize, gearsNumber,
                weight, lights, color, price).toString() : "Invalid input";
    }
}

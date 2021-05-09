package base.syntax.service.impl;

import base.syntax.lib.Inject;
import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.service.UserInputReader;
import base.syntax.service.input.validator.IntegerInputChecker;
import base.syntax.service.input.validator.StringInputChecker;
import base.syntax.storage.BrandStorage;
import java.util.Scanner;

public class UserInputReaderImpl implements UserInputReader {
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_7 = 7;
    private String maxSpeed;
    private String weight;
    private String batteryCapacity;
    private String wheelSize;
    private String gearsNumber;
    @Inject
    private IntegerInputChecker integerInputChecker;
    @Inject
    private StringInputChecker stringInputChecker;

    public String readFromConsole(Integer option) {
        if (option == OPTION_1 || option == OPTION_7 || option == 6) {
            return "";
        }
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.print("Brand of bike: ");
        String bikeBrand = scanner.next();
        while (option == OPTION_5 && BrandStorage.getKey(bikeBrand).length() == 0) {
            System.out.print("Please enter a valid brand name: ");
            bikeBrand = scanner.next();
        }
        String bikeType = option == OPTION_2 ? "FOLDING BIKE" : option == OPTION_3 ? "SPEEDELEC"
                : option == OPTION_4 ? "E-BIKE" : BrandStorage.getKey(bikeBrand);

        if (bikeType.equals("E-BIKE") || bikeType.equals("SPEEDELEC")) {
            System.out.print("The maximum speed (in km/h):  ");
            maxSpeed = integerInputChecker.getCorrectInteger(scanner.next(), option);
            System.out.print("The weight of the e-bike (in grams): ");
            weight = integerInputChecker.getCorrectInteger(scanner.next(), option);
            System.out.print("Battery capacity (in mAh): ");
            batteryCapacity = integerInputChecker.getCorrectInteger(scanner.next(), option);
        }
        if (bikeType.equals("FOLDING BIKE")) {
            System.out.print("The size of the wheels (in inch):  ");
            wheelSize = integerInputChecker.getCorrectInteger(scanner.next(), option);
            System.out.print("The number of gears: ");
            gearsNumber = integerInputChecker.getCorrectInteger(scanner.next(), option);
            System.out.print("The weight of the bike (in grams): ");
            weight = integerInputChecker.getCorrectInteger(scanner.next(), option);
        }
        System.out.print("The availability of lights at front and back (true/false): ");
        final String lights = stringInputChecker.getCorrectString(scanner.next(), option);
        System.out.print("Color: ");
        String color = stringInputChecker.getCorrectString(scanner.next(), option);
        System.out.print("Price: ");
        String price = integerInputChecker.getCorrectInteger(scanner.next(), option);

        return bikeType.equals("E-BIKE") ? new EBike(bikeBrand, maxSpeed, weight, lights,
                batteryCapacity, color, price).toString() : bikeType.equals("SPEEDELEC")
                ? new Speedelec(bikeBrand, maxSpeed, weight, lights, batteryCapacity, color, price)
                .toString() : bikeType.equals("FOLDING BIKE") ? new FoldingBike(bikeBrand,
                wheelSize, gearsNumber, weight, lights, color, price).toString() : "Invalid input";
    }
}

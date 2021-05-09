package base.syntax.service.impl;

import base.syntax.service.input.validator.IntegerInputChecker;
import java.util.Scanner;

public class IntegerInputCheckerImpl implements IntegerInputChecker {
    @Override
    public String getCorrectInteger(String userInput, int option) {
        Scanner scanner = new Scanner(System.in);
        if (option == 5 && userInput.length() == 0) {
            return userInput;
        }
        while (!userInput.matches("[0-9]+")) {
            System.out.print("Incorrect input, please enter digits only: ");
            userInput = scanner.nextLine();
            if (userInput.length() == 0 && option == 5) {
                return userInput;
            }
        }
        return userInput;
    }
}

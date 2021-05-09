package base.syntax.service.impl;

import base.syntax.service.input.validator.StringInputChecker;
import java.util.Scanner;

public class StringInputCheckerImpl implements StringInputChecker {
    @Override
    public String getCorrectString(String userInput, int option) {
        Scanner scanner = new Scanner(System.in);
        if (option == 5 && userInput.length() == 0) {
            return userInput;
        }
        while (!userInput.matches("[a-zA-Z]+")) {
            System.out.print("Incorrect input, please enter letters only: ");
            userInput = scanner.nextLine();
            if (userInput.length() == 0 && option == 5) {
                return userInput;
            }
        }
        return userInput;
    }
}

package base.syntax.menu;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    @Override
    public Integer chooseAction() {
        System.out.println(
                System.lineSeparator() + "Please make your choice: " + System.lineSeparator()
                        + "1 - Show the entire EcoBike catalog " + System.lineSeparator()
                        + "2 – Add a new folding bike " + System.lineSeparator()
                        + "3 – Add a new speedelec " + System.lineSeparator()
                        + "4 – Add a new e-bike " + System.lineSeparator()
                        + "5 – Find the first item of a particular brand " + System.lineSeparator()
                        + "6 – Write to file " + System.lineSeparator() + "7 – Stop the program");
        Scanner userInput = new Scanner(System.in);
        int option = userInput.nextInt();
        while (option < 0 || option > 7) {
            System.out.print("Please choose correct option: ");
            option = userInput.nextInt();
        }
        return option;

    }
}


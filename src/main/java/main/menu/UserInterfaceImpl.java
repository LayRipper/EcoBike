package main.menu;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    @Override
    public String chooseAction() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please make your choice:\n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program");
        return scanner.next().trim();
    }
}

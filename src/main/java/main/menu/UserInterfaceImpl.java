package main.menu;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    @Override
    public String chooseAction() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please make your choice:");
        System.out.println("1 - Show the entire EcoBike catalog");
        System.out.println("2 – Add a new folding bike");
        System.out.println("3 – Add a new speedelec");
        System.out.println("4 – Add a new e-bike");
        System.out.println("5 – Find the first item of a particular brand");
        System.out.println("6 – Write to file");
        System.out.println("7 – Stop the program");
        return scanner.next().trim();
    }
}

package main.menu;

import java.util.Scanner;

public class InputFileImpl implements InputFile {
    @Override
    public String getFile() {
        System.out.println("Please enter the file/filepath to work with: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}

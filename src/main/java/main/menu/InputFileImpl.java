package main.menu;

import java.util.Scanner;

public class InputFileImpl implements InputFile {
    @Override
    public String getFile() {
        System.out.println("Please enter the file/filepath to work with.\n"
                + "Press Enter to leave default src/main/resources/ecobike.txt: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().isBlank() ? "src/main/resources/ecobike.txt" : scanner.next();
    }
}

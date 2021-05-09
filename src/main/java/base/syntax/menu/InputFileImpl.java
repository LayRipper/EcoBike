package base.syntax.menu;

import java.util.Scanner;

public class InputFileImpl implements InputFile {
    @Override
    public String getFile() {
        System.out.print("Please enter the file/filepath to work with.\n"
                + "Press Enter to leave default src/main/resources/ecobike.txt: ");
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String file = scanner.nextLine();
        return file.isEmpty() ? "src/main/resources/ecobike.txt" : file;
    }
}

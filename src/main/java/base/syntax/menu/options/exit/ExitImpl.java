package base.syntax.menu.options.exit;

import base.syntax.menu.options.file.writer.AutoSave;
import base.syntax.menu.options.file.writer.AutoSaveImpl;
import base.syntax.storage.DataStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ExitImpl implements Exit {
    @Override
    public void executeQuery(String userInput, String toFile) {
        List<String> fileData;
        List<String> storedData = DataStorage.getStorage();
        try {
            fileData = Files.readAllLines(Path.of(toFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't find a file with the following path: "
                    + toFile, e);
        }
        if (!storedData.equals(fileData)) {
            System.out.println("Attention! You are trying to exit with unsaved data."
                    + " Type \"save\" to save it or press Enter to exit the program.");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().isBlank()) {
                System.exit(-1);
            } else if (scanner.next().equals("save")) {
                AutoSave autoSave = new AutoSaveImpl();
                autoSave.executeQuery(userInput, toFile);
            }
        }
        System.out.println("The app is closing...");
        System.exit(-1);
    }
}

package base.syntax.menu.options.exit;

import base.syntax.lib.Inject;
import base.syntax.menu.options.file.writer.AutoSave;
import base.syntax.service.DataReader;
import base.syntax.storage.DataStorage;
import java.util.List;
import java.util.Scanner;

public class DataIntegrityCheckerImpl implements DataIntegrityChecker {
    @Inject
    private DataReader reader;
    @Inject
    private AutoSave autoSave;

    @Override
    public String checkUnsavedData(String toFile) {
        List<String> fileData = reader.readFile(toFile);
        List<String> storedData = DataStorage.getStorage();
        if (!storedData.equals(fileData)) {
            System.out.print("Attention! You are trying to exit with unsaved data."
                    + " Would you like to save it? Y/N: ");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String answer = scanner.next();
            while (!answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("y")) {
                System.out.print("Please enter \"Y\" to save data, \"N\" to exit unsaved: ");
                answer = scanner.next();
            }
            if (answer.equalsIgnoreCase("N")) {
                return "The file is closing unsaved";
            } else {
                if (answer.equalsIgnoreCase("Y")) {
                    autoSave.executeQuery("", toFile);
                    return "Saving data completed. The app will close in a moment";
                }
            }
        }
        return "The app is closing...";
    }
}

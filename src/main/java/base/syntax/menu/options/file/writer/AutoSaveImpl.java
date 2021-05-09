package base.syntax.menu.options.file.writer;

import base.syntax.storage.DataStorage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoSaveImpl implements AutoSave {
    @Override
    public String executeQuery(String userInput, String toFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFile))) {
            for (String bike : DataStorage.getStorage()) {
                writer.write(bike + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file with the given path: " + toFile, e);

        }
        return "Data has been successfully saved to the specified path: " + toFile;
    }
}

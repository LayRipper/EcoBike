package base.syntax.service.impl;

import base.syntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderImpl implements DataReader {
    @Override
    public List<String> readFile(String fromFile) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fromFile));
        } catch (IOException e) {
            throw new RuntimeException("There is no such file", e);
        }
        return data;
    }
}

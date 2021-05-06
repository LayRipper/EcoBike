package base.syntax.menu.options.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewBikeWriterImpl implements NewBikeWriter {
    @Override
    public String writeBike(String toFile, String bikeParameters) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(bikeParameters + "\n");
            return bikeParameters;
        } catch (IOException e) {
            throw new RuntimeException("Can't locate the file", e);
        }
    }
}

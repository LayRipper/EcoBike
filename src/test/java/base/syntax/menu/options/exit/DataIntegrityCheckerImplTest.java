package base.syntax.menu.options.exit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.service.DataReader;
import base.syntax.storage.DataStorage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataIntegrityCheckerImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final DataReader READER = (DataReader) INJECTOR.getInstance(DataReader.class);
    private static final DataIntegrityChecker DATA_CHECKER = (DataIntegrityChecker) INJECTOR
            .getInstance(DataIntegrityChecker.class);
    private static final String FILE = "src/test/resources/ecobikeTest.txt";
    private static final InputStream INPUT_STREAM_Y = new ByteArrayInputStream("Y".getBytes());
    private static final InputStream INPUT_STREAM_N = new ByteArrayInputStream("n".getBytes());
    private static final InputStream INPUT_STREAM_INVALID = new ByteArrayInputStream(
            "asdf\nN\n".getBytes());

    @BeforeEach
    public void setUp() {
        DataStorage.getStorage().addAll(READER.readFile(FILE));
    }

    @Test
    void checkUnsavedData_unmodifiedData_ok() {
        assertEquals("The app is closing...", DATA_CHECKER.checkUnsavedData(FILE));
    }

    @Test
    void checkUnsavedData_saveModifiedData_ok() {
        DataStorage.getStorage().add("SPEEDELEC Smart; 40; 9600; false; 13000; brown; 1065");
        System.setIn(INPUT_STREAM_Y);
        assertEquals("Saving data completed. The app will close in a moment",
                DATA_CHECKER.checkUnsavedData(FILE));
    }

    @Test
    void checkUnsavedData_doNotSaveModifiedData_ok() {
        DataStorage.getStorage().add("SPEEDELEC Smart; 40; 9600; false; 13000; brown; 1065");
        System.setIn(INPUT_STREAM_N);
        assertEquals("The file is closing unsaved", DATA_CHECKER.checkUnsavedData(FILE));
    }

    @Test
    void checkUnsavedData_invalidInput_ok() {
        DataStorage.getStorage().add("SPEEDELEC Smart; 40; 9600; false; 13000; brown; 1065");
        System.setIn(INPUT_STREAM_INVALID);
        assertEquals("The file is closing unsaved", DATA_CHECKER.checkUnsavedData(FILE));
    }

    @AfterEach
    public void restoreStreams() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write("SPEEDELEC E-Scooter; 60; 15300; false; 14800; marine; 309\n"
                    + "E-BIKE Lankeleisi; 65; 24200; false; 10000; black; 2399\n"
                    + "FOLDING BIKE Intertool; 24; 21; 12900; true; coral; 1565");
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
        DataStorage.getStorage().clear();
    }
}

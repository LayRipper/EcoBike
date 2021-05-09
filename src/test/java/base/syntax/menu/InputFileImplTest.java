package base.syntax.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputFileImplTest {
    public static final InputStream INPUT_STREAM = new ByteArrayInputStream("\n".getBytes());
    public static final InputStream CUSTOM_FILE_PATH = new ByteArrayInputStream(
            "src/test/resources/ecobikeTest.txt".getBytes());
    private static final Injector INJECTOR = Injector.getInjector();
    private static final InputFile INPUT_FILE = (InputFile) INJECTOR.getInstance(InputFile.class);

    @Test
    void getFile_defaultPath_ok() {
        System.setIn(INPUT_STREAM);
        assertEquals("src/main/resources/ecobike.txt", INPUT_FILE.getFile());
    }

    @Test
    void getFile_customFilePath_ok() {
        System.setIn(CUSTOM_FILE_PATH);
        assertEquals("src/test/resources/ecobikeTest.txt", INPUT_FILE.getFile());
    }
}

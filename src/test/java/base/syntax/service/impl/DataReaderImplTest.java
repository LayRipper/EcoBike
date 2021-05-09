package base.syntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import base.syntax.lib.Injector;
import base.syntax.service.DataReader;
import org.junit.jupiter.api.Test;

class DataReaderImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final DataReader DATA_READER = (DataReader) INJECTOR.getInstance(
            DataReader.class);

    @Test
    void readFile_nonexistingPath_notOk() {
        assertThrows(RuntimeException.class, () -> DATA_READER.readFile("sfs/sssV/Main.class"));
    }
}

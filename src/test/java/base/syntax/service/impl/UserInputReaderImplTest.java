package base.syntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.service.UserInputReader;
import base.syntax.storage.BrandStorage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputReaderImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final InputStream FOLDING_BIKE_STREAM = new ByteArrayInputStream(
            "Intertool\n24\n21\n12900\ntrue\ncoral\n1565\n".getBytes());
    private static final InputStream SPEEDELEC_STREAM = new ByteArrayInputStream(
            "E-Scooter\n60\n15300\n14800\nfalse\nmarine\n309\n".getBytes());
    private static final InputStream E_BIKE_STREAM = new ByteArrayInputStream(
            "Lankeleisi\n65\n24200\n10000\nfalse\nblack\n2399\n".getBytes());
    private static final InputStream BRAND_STREAM = new ByteArrayInputStream(
            "Lankeleisdssi\nLankeleisi\n\n\n\n\n\n\n".getBytes());
    private static UserInputReader USER_INPUT_READER;

    @BeforeEach
    public void setUp() {
        USER_INPUT_READER = (UserInputReader) INJECTOR.getInstance(UserInputReader.class);
    }

    @Test
    void readFromConsole_validOption_ok() {
        assertEquals("", USER_INPUT_READER.readFromConsole(1));
    }

    @Test
    void readFromConsole_foldingBike_ok() {
        System.setIn(FOLDING_BIKE_STREAM);
        assertEquals("FOLDING BIKE Intertool; 24; 21; 12900; true; coral; 1565",
                USER_INPUT_READER.readFromConsole(2));
    }

    @Test
    void readFromConsole_speedelec_ok() {
        System.setIn(SPEEDELEC_STREAM);
        assertEquals("SPEEDELEC E-Scooter; 60; 15300; false; 14800; marine; 309",
                USER_INPUT_READER.readFromConsole(3));
    }

    @Test
    void readFromConsole_ebike_ok() {
        System.setIn(E_BIKE_STREAM);
        assertEquals("E-BIKE Lankeleisi; 65; 24200; false; 10000; black; 2399",
                USER_INPUT_READER.readFromConsole(4));
    }

    @Test
    void readFromConsole_skipInputIncorrectBrand_ok() {
        BrandStorage.getBrandStorage().put("E-BIKE", List.of("Lankeleisi"));
        System.setIn(BRAND_STREAM);
        assertEquals("E-BIKE Lankeleisi; ; ; ; ; ; ",
                USER_INPUT_READER.readFromConsole(5));
    }
}

package base.syntax.menu.options.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.service.DataReader;
import base.syntax.storage.DataStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchEngineImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final SearchEngine SEARCH_ENGINE = (SearchEngine) INJECTOR.getInstance(
            SearchEngine.class);
    private static final DataReader READER = (DataReader) INJECTOR.getInstance(DataReader.class);
    private static final String BIKE_PARAMETERS =
            "Lankeleisi; 65; 24200; " + "false; 10000; black; 2399";
    private static final String FILE = "src/test/resources/ecobikeTest.txt";

    @BeforeAll
    static void setUp() {
        DataStorage.getStorage().addAll(READER.readFile(FILE));
    }

    @Test
    void executeQuery_correctInput_ok() {
        assertEquals("E-BIKE Lankeleisi with 24200 mAh battery and no head/tail light.\n"
                + "Price: 2399 euros.\n", SEARCH_ENGINE.executeQuery(BIKE_PARAMETERS, FILE));
    }
}

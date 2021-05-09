package base.syntax.menu.options.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import org.junit.jupiter.api.Test;

class NewBikeWriterImplTest {

    private static final Injector INJECTOR = Injector.getInjector();
    private static final NewBikeWriterImpl NEW_BIKE_WRITER = (NewBikeWriterImpl) INJECTOR
            .getInstance(NewBikeWriterImpl.class);
    private static final String BIKE_PARAMETERS =
            "E-BIKE Lankeleisi; 65; " + "24200; false; 10000; black; 2399";
    private static final String FILE = "src/test/resources/ecobikeTest.txt";

    @Test
    void executeQuery_correctInput_ok() {
        assertEquals("Bike was successfully added to the data storage.",
                NEW_BIKE_WRITER.executeQuery(BIKE_PARAMETERS, FILE));
    }

}

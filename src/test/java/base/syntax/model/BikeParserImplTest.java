package base.syntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.service.BikeParser;
import org.junit.jupiter.api.Test;

public class BikeParserImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final BikeParser BIKE_PARSER = (BikeParser) INJECTOR.getInstance(
            BikeParser.class);
    private static final String EBIKE = "E-BIKE Lankeleisi; 65; 24200; false; 10000; black; 2399";
    private static final String FOLDING_BIKE = "FOLDING BIKE Intertool; 24; "
            + "21; 12900; true; coral; 1565";
    private static final String SPEEDELEC = "SPEEDELEC E-Scooter; 60; 15300; "
            + "false; 14800; marine; 309";
    private static final String INVALID_BIKE = "MOUNTAIN BIKE E-Scooter; 60; "
            + "15300; false; 14800; marine; 309";
    private static final String INVALID_STRUCTURE = "FOLDIdsd";

    @Test
    void parseBike_validEBike_ok() {
        assertEquals(new EBike("Lankeleisi", "65", "24200", "false", "10000", "black", "2399"),
                BIKE_PARSER.parseBike(EBIKE));
    }

    @Test
    void parseBike_validFoldingBike_ok() {
        assertEquals(new FoldingBike("Intertool", "24", "21", "12900", "true", "coral", "1565"),
                BIKE_PARSER.parseBike(FOLDING_BIKE));
    }

    @Test
    void parseBike_validSpeedelec_ok() {
        assertEquals(new Speedelec("E-Scooter", "60", "15300", "false", "14800", "marine", "309"),
                BIKE_PARSER.parseBike(SPEEDELEC));
    }

    @Test
    void parseBike_invalidBike_ok() {
        assertEquals(new Speedelec(), BIKE_PARSER.parseBike(INVALID_BIKE));
    }

    @Test
    void parseBike_invalidStructure_ok() {
        assertEquals(new Speedelec(), BIKE_PARSER.parseBike(INVALID_STRUCTURE));
    }

}

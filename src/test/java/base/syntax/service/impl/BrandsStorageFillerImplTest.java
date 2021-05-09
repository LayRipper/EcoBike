package base.syntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.service.BrandStorageFiller;
import base.syntax.service.DataReader;
import base.syntax.storage.BrandStorage;
import base.syntax.storage.DataStorage;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BrandsStorageFillerImplTest {
    private static final Injector INJECTOR = Injector.getInjector();
    private static final BrandStorageFiller BRAND_STORAGE_FILLER = (BrandStorageFiller) INJECTOR
            .getInstance(BrandStorageFiller.class);
    private static final DataReader DATA_READER = (DataReader) INJECTOR.getInstance(
            DataReader.class);

    @BeforeAll
    static void setUp() {
        DataStorage.getStorage().addAll(DATA_READER.readFile("src/test/resources/ecobikeTest.txt"));
    }

    @Test
    void fillBrandStorage_ok() {
        BRAND_STORAGE_FILLER.fillBrandStorage();
        assertEquals(Map.of("SPEEDELEC", List.of("E-Scooter"), "FOLDING BIKE", List.of("Intertool"),
                "E-BIKE", List.of("Lankeleisi")), BrandStorage.getBrandStorage());
    }
}

package base.syntax.menu.options.catalogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import base.syntax.storage.DataStorage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CatalogueCompilerImplTest {
    private final Injector injector = Injector.getInjector();
    private final CatalogueCompiler catalogueCompiler = (CatalogueCompiler) injector.getInstance(
            CatalogueCompiler.class);

    @BeforeAll
    public static void setUp() {
        DataStorage.getStorage().add("E-BIKE Ferrari; 60; 28900; false; 21000; brown; 825");
    }

    @AfterAll
    public static void clean() {
        DataStorage.getStorage().clear();
    }

    @Test
    public void executeQuery_validData_ok() {
        assertEquals("E-BIKE Ferrari with 28900 mAh battery and no head/tail light.\n"
                + "Price: 825 euros.\n", catalogueCompiler.executeQuery("", ""));

    }

}

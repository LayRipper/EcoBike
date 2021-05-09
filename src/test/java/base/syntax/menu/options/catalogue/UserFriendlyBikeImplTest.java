package base.syntax.menu.options.catalogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import base.syntax.lib.Injector;
import org.junit.jupiter.api.Test;

public class UserFriendlyBikeImplTest {
    private static final String FOLDING_BIKE = "FOLDING BIKE VNV; 24; 1; 10100; true; red; 575";
    private static final Injector INJECTOR = Injector.getInjector();
    private final UserFriendlyBike bike = (UserFriendlyBike) INJECTOR.getInstance(
            UserFriendlyBike.class);

    @Test
    public void formBike_foldingBIkeSpecs_ok() {
        assertEquals(
                "FOLDING BIKE VNV with 1 gear(s) and head/tail light.\n" + "Price: 575 euros.\n",
                bike.formBike(FOLDING_BIKE));
    }
}

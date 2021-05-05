package local.storage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BrandsStorageFillerImpl implements BrandStorageFiller {
    private static final String SPEEDELEC = "SPEEDELEC";
    private static final String FOLDING_BIKE = "FOLDING BIKE";
    private static final String E_BIKE = "E-BIKE";
    private static final String SEMICOLON_DELIMITER = ";";
    private static final int ELECTROBIKE_BRAND_POSITION = 2;
    private static final int FOLDING_BIKE_BRAND_POSITION = 3;

    @Override
    public void fillBrandStorage() {
        List<String> speedelecBrands = DataStorage.getStorage().parallelStream()
                .filter(bike -> bike.contains(SPEEDELEC))
                .flatMap(n -> Arrays.stream(n.replaceAll(SEMICOLON_DELIMITER, "")
                        .split(" ")).limit(ELECTROBIKE_BRAND_POSITION))
                .filter(type -> !type.equals(SPEEDELEC))
                .distinct()
                .collect(Collectors.toList());

        List<String> foldingBikeBrands = DataStorage.getStorage().parallelStream()
                .filter(bike -> bike.contains(FOLDING_BIKE))
                .flatMap(n -> Arrays.stream(n.replaceAll(SEMICOLON_DELIMITER, "")
                        .split(" ")).limit(FOLDING_BIKE_BRAND_POSITION))
                .filter(type -> !type.equals("FOLDING") && !type.equals("BIKE"))
                .distinct()
                .collect(Collectors.toList());

        List<String> ebikeBrands = DataStorage.getStorage().parallelStream()
                .filter(bike -> bike.contains(E_BIKE))
                .flatMap(n -> Arrays.stream(n.replaceAll(SEMICOLON_DELIMITER, "")
                        .split(" ")).limit(ELECTROBIKE_BRAND_POSITION))
                .filter(type -> !type.equals(E_BIKE))
                .distinct()
                .collect(Collectors.toList());

        BrandStorage.getBrandStorage().put(SPEEDELEC, speedelecBrands);
        BrandStorage.getBrandStorage().put(FOLDING_BIKE, foldingBikeBrands);
        BrandStorage.getBrandStorage().put(E_BIKE, ebikeBrands);
    }
}

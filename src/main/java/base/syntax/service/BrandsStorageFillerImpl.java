package base.syntax.service;

import base.syntax.model.Bike;
import base.syntax.model.BikeParser;
import base.syntax.model.BikeParserImpl;
import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.storage.BrandStorage;
import base.syntax.storage.DataStorage;
import java.util.List;
import java.util.stream.Collectors;

public class BrandsStorageFillerImpl implements BrandStorageFiller {
    private BikeParser bikeParser = new BikeParserImpl();

    @Override
    public void fillBrandStorage() {
        List<String> speedelecBrands = DataStorage.getStorage().parallelStream()
                .map(bikeParser::parseBike)
                .filter(bike -> bike.getClass() == Speedelec.class)
                .map(Bike::getBrand)
                .distinct()
                .collect(Collectors.toList());

        List<String> foldingBikeBrands = DataStorage.getStorage().parallelStream()
                .map(bikeParser::parseBike)
                .filter(bike -> bike.getClass() == FoldingBike.class)
                .map(Bike::getBrand)
                .distinct()
                .collect(Collectors.toList());

        List<String> ebikeBrands = DataStorage.getStorage().parallelStream()
                .map(bikeParser::parseBike)
                .filter(bike -> bike.getClass() == EBike.class)
                .map(Bike::getBrand)
                .distinct()
                .collect(Collectors.toList());

        BrandStorage.getBrandStorage().put("SPEEDELEC", speedelecBrands);
        BrandStorage.getBrandStorage().put("FOLDING BIKE", foldingBikeBrands);
        BrandStorage.getBrandStorage().put("E-BIKE", ebikeBrands);
    }
}

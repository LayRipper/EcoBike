package base.syntax.service.impl;

import base.syntax.lib.Inject;
import base.syntax.model.Bike;
import base.syntax.model.EBike;
import base.syntax.model.FoldingBike;
import base.syntax.model.Speedelec;
import base.syntax.service.BikeParser;
import base.syntax.service.BrandStorageFiller;
import base.syntax.storage.BrandStorage;
import base.syntax.storage.DataStorage;
import java.util.List;
import java.util.stream.Collectors;

public class BrandsStorageFillerImpl implements BrandStorageFiller {
    @Inject
    private BikeParser bikeParser;

    @Override
    public void fillBrandStorage() {
        List<String> speedelecBrands = DataStorage.getStorage().parallelStream().map(
                bikeParser::parseBike).filter(bike -> bike.getClass() == Speedelec.class).map(
                Bike::getBrand).distinct().collect(Collectors.toList());

        List<String> foldingBikeBrands = DataStorage.getStorage().parallelStream().map(
                bikeParser::parseBike).filter(bike -> bike.getClass() == FoldingBike.class).map(
                Bike::getBrand).distinct().collect(Collectors.toList());

        List<String> ebikeBrands = DataStorage.getStorage().parallelStream().map(
                bikeParser::parseBike).filter(bike -> bike.getClass() == EBike.class).map(
                Bike::getBrand).distinct().collect(Collectors.toList());

        BrandStorage.getBrandStorage().put("SPEEDELEC", speedelecBrands);
        BrandStorage.getBrandStorage().put("FOLDING BIKE", foldingBikeBrands);
        BrandStorage.getBrandStorage().put("E-BIKE", ebikeBrands);
    }
}

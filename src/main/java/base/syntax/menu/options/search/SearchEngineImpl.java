package base.syntax.menu.options.search;

import base.syntax.lib.Inject;
import base.syntax.menu.options.catalogue.UserFriendlyBike;
import base.syntax.storage.DataStorage;
import java.util.Arrays;

public class SearchEngineImpl implements SearchEngine {
    @Inject
    private UserFriendlyBike userFriendlyBike;

    @Override
    public String executeQuery(String givenBikeParameters, String toFile) {

        String[] bikeParametersArray = givenBikeParameters.replaceAll(";", "").trim().split(" ");

        String foundBike = DataStorage.getStorage().stream().filter(
                n -> Arrays.asList(n.replaceAll(";", "").split(" "))
                        .containsAll(Arrays.asList(bikeParametersArray))).findFirst().orElse(
                "No matches found. Try other parameters.");
        return userFriendlyBike.formBike(foundBike);
    }
}

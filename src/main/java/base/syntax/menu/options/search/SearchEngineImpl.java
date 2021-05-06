package base.syntax.menu.options.search;

import base.syntax.storage.DataStorage;
import java.util.Arrays;

public class SearchEngineImpl implements SearchEngine {
    @Override
    public void executeQuery(String givenBikeParameters, String toFile) {
        String[] bikeParametersArray = givenBikeParameters
                .replaceAll(";", "").trim().split(" ");

        System.out.println(DataStorage.getStorage().stream()
                .filter(n -> Arrays.asList(n.replaceAll(";", "")
                        .split(" ")).containsAll(Arrays.asList(bikeParametersArray)))
                .findFirst().orElse("No matches found. Try other parameters."));
    }
}

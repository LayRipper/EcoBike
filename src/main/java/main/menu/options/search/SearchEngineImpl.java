package main.menu.options.search;

import java.util.Arrays;
import java.util.List;

public class SearchEngineImpl implements SearchEngine {
    @Override
    public String searchBike(List<String> dataStorage, String givenBikeParameters) {
        String[] bikeParametersArray = givenBikeParameters
                .replaceAll(";", "").trim().split(" ");
        return dataStorage.stream()
                .filter(n -> Arrays.asList(n.replaceAll(";", "")
                        .split(" ")).containsAll(Arrays.asList(bikeParametersArray)))
                .findFirst().orElse("No matches found. Try other parameters.");
    }
}

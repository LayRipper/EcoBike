package main.menu.options.search;

import java.util.List;

public interface SearchEngine {
    String searchBike(List<String> bikeList, String bikeParameters);
}

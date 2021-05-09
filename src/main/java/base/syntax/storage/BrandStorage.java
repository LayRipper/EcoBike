package base.syntax.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandStorage {
    private static final Map<String, List<String>> brandStorage = new HashMap<>();

    public static Map<String, List<String>> getBrandStorage() {
        return brandStorage;
    }

    public static String getKey(String brand) {
        for (Map.Entry<String, List<String>> map : brandStorage.entrySet()) {
            if (map.getValue().contains(brand)) {
                return map.getKey();
            }
        }
        return "";
    }
}

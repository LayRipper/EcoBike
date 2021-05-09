package base.syntax.storage;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final List<String> storage = new ArrayList<>();

    public static List<String> getStorage() {
        return storage;
    }
}

package base.syntax.menu.options.writer;

import base.syntax.storage.DataStorage;

public class NewBikeWriterImpl implements NewBikeWriter {
    @Override
    public String executeQuery(String bikeParameters, String toFile) {
        DataStorage.getStorage().add(bikeParameters);
        return "Bike was successfully added to the data storage.";
    }
}

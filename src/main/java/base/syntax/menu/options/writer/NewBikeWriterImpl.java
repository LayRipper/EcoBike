package base.syntax.menu.options.writer;

import base.syntax.storage.DataStorage;

public class NewBikeWriterImpl implements NewBikeWriter {
    @Override
    public void executeQuery(String bikeParameters, String toFile) {
        DataStorage.getStorage().add(bikeParameters);
        System.out.println("Bike was successfully added to the data storage.");
    }
}

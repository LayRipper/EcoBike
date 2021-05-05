package main.menu.strategy;

import local.storage.DataStorage;
import main.menu.options.catalogue.CatalogueCompilerImpl;
import main.menu.options.insert.NewBikeWriter;
import main.menu.options.insert.NewBikeWriterImpl;
import main.menu.options.search.SearchEngineImpl;
import main.menu.UserInputReader;
import main.menu.UserInputReaderImpl;

public class UserInterfaceStrategyImpl implements UserInterfaceStrategy {
    private static final NewBikeWriter BIKE_WRITER = new NewBikeWriterImpl();
    private static final UserInputReader INPUT_READER = new UserInputReaderImpl();

    public void doAction(String option, String toFile) {
        switch (option) {
            case "1":
                System.out.println(new CatalogueCompilerImpl()
                        .complyCatalogue(DataStorage.getStorage()));
                break;
            case "2":
                System.out.println(BIKE_WRITER.writeBike(toFile,
                        INPUT_READER.readFromConsole("2")));
                break;
            case "3":
                System.out.println(BIKE_WRITER.writeBike(toFile,
                        INPUT_READER.readFromConsole("3")));
                break;
            case "4":
                System.out.println(BIKE_WRITER.writeBike(toFile,
                        INPUT_READER.readFromConsole("4")));
                break;
            case "5":
                System.out.println(new SearchEngineImpl().searchBike(DataStorage.getStorage(),
                        INPUT_READER.readFromConsole("5")));
                break;
            case "6":
                System.out.println(BIKE_WRITER.writeBike(toFile,
                        INPUT_READER.readFromConsole("6")));
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Unknown operation type");
        }
    }
}

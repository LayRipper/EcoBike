package base.syntax.menu.strategy;

import java.util.Map;

public class UserInterfaceStrategyImpl implements UserInterfaceStrategy {
    private final Map<String, QueryExecutor> executionMap;

    public UserInterfaceStrategyImpl(Map<String, QueryExecutor> strategyMap) {
        this.executionMap = strategyMap;
    }

    public QueryExecutor getAction(String option) {
        return executionMap.get(option);
    }



    /*
    private static final NewBikeWriter BIKE_WRITER = new NewBikeWriterImpl();
    private static final UserInputReader INPUT_READER = new UserInputReaderImpl();

    public void getAction(String option) {
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

     */
}

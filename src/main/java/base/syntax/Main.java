package base.syntax;

import base.syntax.menu.InputFile;
import base.syntax.menu.InputFileImpl;
import base.syntax.menu.UserInterface;
import base.syntax.menu.UserInterfaceImpl;
import base.syntax.menu.options.catalogue.CatalogueCompilerImpl;
import base.syntax.menu.options.exit.ExitImpl;
import base.syntax.menu.options.search.SearchEngineImpl;
import base.syntax.menu.options.writer.NewBikeWriterImpl;
import base.syntax.menu.strategy.QueryExecutor;
import base.syntax.menu.strategy.UserInterfaceStrategy;
import base.syntax.menu.strategy.UserInterfaceStrategyImpl;
import base.syntax.service.DataReader;
import base.syntax.service.DataReaderImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, QueryExecutor> strategyMap = new HashMap<>();
        strategyMap.put("1", new CatalogueCompilerImpl());
        strategyMap.put("2", new NewBikeWriterImpl());
        strategyMap.put("3", new NewBikeWriterImpl());
        strategyMap.put("4", new NewBikeWriterImpl());
        strategyMap.put("5", new SearchEngineImpl());
        strategyMap.put("6", new NewBikeWriterImpl());
        strategyMap.put("7", new ExitImpl());
        UserInterfaceStrategy userInterfaceStrategy = new UserInterfaceStrategyImpl(strategyMap);

        InputFile inputFile = new InputFileImpl();
        String retrievedFile = inputFile.getFile();

        DataReader reader = new DataReaderImpl();
        reader.readFile(retrievedFile);

        UserInterface userInterface = new UserInterfaceImpl();
        String option = userInterface.chooseAction();

        userInterfaceStrategy.getAction(option);
    }
}

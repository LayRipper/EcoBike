package base.syntax;

import base.syntax.lib.Injector;
import base.syntax.menu.InputFile;
import base.syntax.menu.UserInterface;
import base.syntax.menu.UserInterfaceImpl;
import base.syntax.menu.options.catalogue.CatalogueCompiler;
import base.syntax.menu.options.exit.Exit;
import base.syntax.menu.options.file.writer.AutoSave;
import base.syntax.menu.options.search.SearchEngine;
import base.syntax.menu.options.writer.NewBikeWriter;
import base.syntax.menu.strategy.QueryExecutor;
import base.syntax.menu.strategy.UserInterfaceStrategy;
import base.syntax.menu.strategy.UserInterfaceStrategyImpl;
import base.syntax.service.BrandStorageFiller;
import base.syntax.service.DataReader;
import base.syntax.service.UserInputReader;
import base.syntax.storage.DataStorage;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInjector();
        InputFile inputFile = (InputFile) injector.getInstance(InputFile.class);
        final BrandStorageFiller brandStorageFiller = (BrandStorageFiller) injector.getInstance(
                BrandStorageFiller.class);
        final DataReader dataReader = (DataReader) injector.getInstance(DataReader.class);
        final String retrievedFile = inputFile.getFile();
        UserInputReader userInputReader = (UserInputReader) injector.getInstance(
                UserInputReader.class);
        UserInterfaceImpl userInterface = (UserInterfaceImpl) injector.getInstance(
                UserInterface.class);

        Map<Integer, QueryExecutor> strategyMap = new HashMap<>();
        strategyMap.put(1, (QueryExecutor) injector.getInstance(CatalogueCompiler.class));
        strategyMap.put(2, (QueryExecutor) injector.getInstance(NewBikeWriter.class));
        strategyMap.put(3, (QueryExecutor) injector.getInstance(NewBikeWriter.class));
        strategyMap.put(4, (QueryExecutor) injector.getInstance(NewBikeWriter.class));
        strategyMap.put(5, (QueryExecutor) injector.getInstance(SearchEngine.class));
        strategyMap.put(6, (QueryExecutor) injector.getInstance(AutoSave.class));
        strategyMap.put(7, (QueryExecutor) injector.getInstance(Exit.class));
        final UserInterfaceStrategy userInterfaceStrategy = new UserInterfaceStrategyImpl(
                strategyMap);

        DataStorage.getStorage().addAll(dataReader.readFile(retrievedFile));
        brandStorageFiller.fillBrandStorage();

        while (true) {
            Integer option = userInterface.chooseAction();
            System.out.println(userInterfaceStrategy.getAction(option)
                    .executeQuery(userInputReader.readFromConsole(option), retrievedFile));
        }
    }
}


import data.reader.DataReader;
import data.reader.DataReaderImpl;
import local.storage.BrandStorageDto;
import local.storage.BrandsStorageDtoImpl;
import local.storage.DataStorage;
import main.menu.InputFile;
import main.menu.InputFileImpl;
import main.menu.UserInterface;
import main.menu.UserInterfaceImpl;
import main.menu.strategy.UserInterfaceStrategy;
import main.menu.strategy.UserInterfaceStrategyImpl;

public class Main {
    public static void main(String[] args) {
        InputFile inputFile = new InputFileImpl();
        String mainFile = inputFile.getFile();

        DataReader reader = new DataReaderImpl();
        DataStorage.getStorage().addAll(reader.readFile(mainFile));

        BrandStorageDto brandStorageDto = new BrandsStorageDtoImpl();
        brandStorageDto.fillBrandStorage();

        UserInterface userInterface = new UserInterfaceImpl();
        UserInterfaceStrategy userInterfaceStrategy = new UserInterfaceStrategyImpl();
        userInterfaceStrategy.doAction(userInterface.chooseAction(), mainFile);
    }
}

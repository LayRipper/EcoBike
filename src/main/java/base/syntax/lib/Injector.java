package base.syntax.lib;

import base.syntax.menu.InputFile;
import base.syntax.menu.InputFileImpl;
import base.syntax.menu.UserInterface;
import base.syntax.menu.UserInterfaceImpl;
import base.syntax.menu.options.catalogue.CatalogueCompiler;
import base.syntax.menu.options.catalogue.CatalogueCompilerImpl;
import base.syntax.menu.options.catalogue.UserFriendlyBike;
import base.syntax.menu.options.catalogue.UserFriendlyBikeImpl;
import base.syntax.menu.options.exit.DataIntegrityChecker;
import base.syntax.menu.options.exit.DataIntegrityCheckerImpl;
import base.syntax.menu.options.exit.Exit;
import base.syntax.menu.options.exit.ExitImpl;
import base.syntax.menu.options.file.writer.AutoSave;
import base.syntax.menu.options.file.writer.AutoSaveImpl;
import base.syntax.menu.options.search.SearchEngine;
import base.syntax.menu.options.search.SearchEngineImpl;
import base.syntax.menu.options.writer.NewBikeWriter;
import base.syntax.menu.options.writer.NewBikeWriterImpl;
import base.syntax.menu.strategy.UserInterfaceStrategy;
import base.syntax.menu.strategy.UserInterfaceStrategyImpl;
import base.syntax.service.BikeParser;
import base.syntax.service.BrandStorageFiller;
import base.syntax.service.DataReader;
import base.syntax.service.UserInputReader;
import base.syntax.service.impl.BikeParserImpl;
import base.syntax.service.impl.BrandsStorageFillerImpl;
import base.syntax.service.impl.DataReaderImpl;
import base.syntax.service.impl.IntegerInputCheckerImpl;
import base.syntax.service.impl.StringInputCheckerImpl;
import base.syntax.service.impl.UserInputReaderImpl;
import base.syntax.service.input.validator.IntegerInputChecker;
import base.syntax.service.input.validator.StringInputChecker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    private static final Injector injector = new Injector();

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public static Injector getInjector() {
        return injector;
    }

    public Object getInstance(Class<?> interfaceClazz) {
        Object clazzImplementationInstance = null;
        Class<?> clazz = findImplementation(interfaceClazz);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object fieldInstance = getInstance(field.getType());
                clazzImplementationInstance = createNewInstance(clazz);
                field.setAccessible(true);
                try {
                    field.set(clazzImplementationInstance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("", e);
                }
            }
        }
        return createNewInstance(clazz);
    }

    private Class<?> findImplementation(Class<?> interfaceClazz) {
        Map<Class<?>, Class<?>> implementationMap = new HashMap<>();
        implementationMap.put(InputFile.class, InputFileImpl.class);
        implementationMap.put(BrandStorageFiller.class, BrandsStorageFillerImpl.class);
        implementationMap.put(UserInputReader.class, UserInputReaderImpl.class);
        implementationMap.put(UserInterface.class, UserInterfaceImpl.class);
        implementationMap.put(UserInterfaceStrategy.class, UserInterfaceStrategyImpl.class);
        implementationMap.put(DataReader.class, DataReaderImpl.class);
        implementationMap.put(BikeParser.class, BikeParserImpl.class);
        implementationMap.put(IntegerInputChecker.class, IntegerInputCheckerImpl.class);
        implementationMap.put(StringInputChecker.class, StringInputCheckerImpl.class);
        implementationMap.put(UserFriendlyBike.class, UserFriendlyBikeImpl.class);
        implementationMap.put(SearchEngine.class, SearchEngineImpl.class);
        implementationMap.put(NewBikeWriter.class, NewBikeWriterImpl.class);
        implementationMap.put(AutoSave.class, AutoSaveImpl.class);
        implementationMap.put(Exit.class, ExitImpl.class);
        implementationMap.put(CatalogueCompiler.class, CatalogueCompilerImpl.class);
        implementationMap.put(DataIntegrityChecker.class, DataIntegrityCheckerImpl.class);
        if (!interfaceClazz.isInterface()) {
            return interfaceClazz;
        }
        return implementationMap.get(interfaceClazz);
    }

    Object createNewInstance(Class<?> clazz) {
        if (instances.containsKey(clazz)) {
            return instances.get(clazz);
        }
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            instances.put(clazz, instance);
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Can't create an instance of a class " + clazz.getName(), e);
        }
    }
}

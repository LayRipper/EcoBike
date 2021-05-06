package base.syntax.menu.options.catalogue;

import base.syntax.menu.strategy.QueryExecutor;

public interface CatalogueCompiler extends QueryExecutor {
    void executeQuery(String userInput, String toFile);
}

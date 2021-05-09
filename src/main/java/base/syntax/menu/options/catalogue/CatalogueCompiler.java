package base.syntax.menu.options.catalogue;

import base.syntax.menu.strategy.QueryExecutor;

public interface CatalogueCompiler extends QueryExecutor {
    String executeQuery(String userInput, String toFile);
}

package base.syntax.menu.options.search;

import base.syntax.menu.strategy.QueryExecutor;

public interface SearchEngine extends QueryExecutor {
    void executeQuery(String userInput, String toFile);
}

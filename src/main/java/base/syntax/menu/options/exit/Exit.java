package base.syntax.menu.options.exit;

import base.syntax.menu.strategy.QueryExecutor;

public interface Exit extends QueryExecutor {
    void executeQuery(String userInput, String toFile);
}

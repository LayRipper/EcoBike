package base.syntax.menu.options.exit;

import base.syntax.menu.strategy.QueryExecutor;

public interface Exit extends QueryExecutor {
    String executeQuery(String userInput, String toFile);
}

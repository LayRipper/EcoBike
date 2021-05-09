package base.syntax.menu.options.file.writer;

import base.syntax.menu.strategy.QueryExecutor;

public interface AutoSave extends QueryExecutor {
    String executeQuery(String userInput, String toFile);
}

package base.syntax.menu.options.writer;

import base.syntax.menu.strategy.QueryExecutor;

public interface NewBikeWriter extends QueryExecutor {
    void executeQuery(String userInput, String toFile);
}

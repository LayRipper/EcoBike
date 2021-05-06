package base.syntax.menu.options.search;

import base.syntax.menu.strategy.QueryExecutor;

public interface SearchEngine extends QueryExecutor {
    public String searchBike(String inputParameters, String toFile);
}

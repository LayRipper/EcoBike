package base.syntax.menu.strategy;

import java.util.Map;

public class UserInterfaceStrategyImpl implements UserInterfaceStrategy {
    private final Map<Integer, QueryExecutor> executionMap;

    public UserInterfaceStrategyImpl(Map<Integer, QueryExecutor> strategyMap) {
        this.executionMap = strategyMap;
    }

    public QueryExecutor getAction(Integer option) {
        return executionMap.get(option);
    }
}

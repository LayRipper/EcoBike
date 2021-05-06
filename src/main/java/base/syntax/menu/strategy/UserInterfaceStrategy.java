package base.syntax.menu.strategy;

public interface UserInterfaceStrategy {
    QueryExecutor getAction(String option);
}

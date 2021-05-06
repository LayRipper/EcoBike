package base.syntax.menu.options.exit;

public class ExitImpl implements Exit {
    @Override
    public void executeQuery(String userInput, String toFile) {
        System.out.println("The app is closing...");
        System.exit(-1);
    }
}

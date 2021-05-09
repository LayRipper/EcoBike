package base.syntax.menu.options.exit;

import base.syntax.lib.Inject;

public class ExitImpl implements Exit {
    @Inject
    private DataIntegrityChecker dataChecker;

    @Override
    public String executeQuery(String userInput, String toFile) {
        System.out.println(dataChecker.checkUnsavedData(toFile));
        System.exit(0);
        return "";
    }
}
